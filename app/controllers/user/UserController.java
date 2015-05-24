package controllers.user;

import java.awt.image.BufferedImage;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.TypedQuery;
import javax.security.auth.login.FailedLoginException;

import models.user.Digest;
import models.user.Login;
import models.user.NewPassword;
import models.user.User;

import org.apache.commons.io.FileUtils;

import play.Logger;
import play.Play;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import utils.actions.SessionAuth;
import utils.crypto.Crypto;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and
 * manipulate {@link User} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class UserController extends AbstractCRUDController<User, Long> {
	
	private byte [] cachedDefaultAavatar;

	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is
	 * "@Named("UserDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public UserController(@Named("UserDAO") GenericDAO<User, Long> dao) {
		super(dao);
	}
	
	/**
	 * Creates a User object via the {@link GenericDAO}, given by the serialized Object of
	 * the delivered JSON Node from the HTTP request.
	 * 
	 * @return
	 */
	@Transactional
	public Result create() {
		JsonNode node = request().body().asJson();
		User created = null;
		try {
			User t = Json.fromJson(node, dao.getModel());
			Digest digest = new Digest();
			digest.generateDigest(t.getPassword());
			created = dao.create(t);
			created.setDigest(digest);
		} catch (Exception e) {
			String msg = "Failed to create, " + dao.getModel().getSimpleName();
			String email = (null == created) ? "User is null" : created.getEmail();
			Logger.error(msg + " E-Mail: " + email, e);
			return internalServerError(msg);
		}
		return created(Json.toJson(created));
	}

	/**
	 * Processes a login request. Retrieving username (email) and password via a
	 * JsonNode. Validates username and password, creates user session and
	 * returns the {@link User} object as a JsonNode.
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Result login() {
		Login login = Json.fromJson(request().body().asJson(), Login.class);
		TypedQuery<User> query = JPA.em().createQuery(
				"select a from User a where a.email = :email", User.class);
		query.setParameter("email", login.getEmail());
		User user;
		try {
			List<User> data = dao.find(query);
			if (null == data || data.size() == 0) {
				throw new FailedLoginException();
			} else {
				user = data.get(0);
				boolean success = false;
				try {
					success = Crypto.isPasswordValid(login.getPassword(),
							user.getDigest());
				} catch (GeneralSecurityException e) {
					throw new FailedLoginException();
				}
				if (success) {
					session().clear();
					session("user_id", Long.toString(user.getId()));
					session("email", user.getEmail());
					session("role", user.getRole().getName());
					session("time", Long.toString(System.currentTimeMillis()));
				} else {
					throw new FailedLoginException();
				}
			}
		} catch (FailedLoginException e) {
			return unauthorized("Login failed, Username or Password wrong.");
		} catch (Exception e) {
			String msg = "Login failed, due to a technical error.";
			Logger.error(msg, e);
			return internalServerError(msg);
		}

		return ok(Json.toJson(user));
	}

	/**
	 * Logout method. Clears the user session.
	 * 
	 * @return
	 */
	public Result logout() {
		session().clear();
		return ok();
	}

	/**
	 * changePassword Method receives the current password, the new password and
	 * a repetition of the new password. The current password is being checked
	 * and if the new password is the same as its repetition, it is saved via
	 * the {@link GenericDAO} object.
	 * 
	 * @return
	 */
	@SessionAuth
	@Transactional
	public Result changePassword() {
		NewPassword pw = Json.fromJson(request().body().asJson(),
				NewPassword.class);
		String email = session().get("email");
		TypedQuery<User> query = JPA.em().createQuery(
				"select a from User a where a.email = :email", User.class);
		query.setParameter("email", email);
		User user;
		try {
			List<User> data = dao.find(query);
			user = data.get(0);
			boolean success = false;
			try {
				success = Crypto.isPasswordValid(pw.getCurrentpassword(),
						user.getDigest());
			} catch (GeneralSecurityException e) {
				throw new FailedLoginException();
			}
			if (success) {
				if (pw.getNewpassword().equals(pw.getRepeatpassword())) {
					user.getDigest().generateDigest(pw.getNewpassword());
				} else {
					throw new FailedLoginException();
				}
			} else {
				throw new FailedLoginException();
			}
		} catch (FailedLoginException e) {
			return unauthorized("Not allowed to change password");
		} catch (Exception e) {
			String msg = "Password change failed, due to a technical error.";
			Logger.error(msg, e);
			return internalServerError(msg);
		}

		return ok();
	}
	
	/**
	 * Returns the avatar image as binary Data for a delivered user id.
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public Result getAvatar(Long id) {
		try {
			User user = dao.get(id);
			byte [] imageBytes = user.getAvatar();
			if (imageBytes == null) {
				if(cachedDefaultAavatar == null) {
					File avatar = Play.application().getFile("public/" + Play.application().configuration().getString("defaultavatar"));
					imageBytes = FileUtils.readFileToByteArray(avatar);
				} else {
					imageBytes = cachedDefaultAavatar;
				}
			}
			return ok(imageBytes).as("image/jpeg");
		} catch (Exception e) {
			String msg = "Failed to get avatar.";
			Logger.error(msg, e);
			return internalServerError(msg);
		}
	}

	/**
	 * Upload users Avatar image.
	 * 
	 * @return
	 */
	@SessionAuth
	@Transactional
	public Result uploadAvatar() {
		try {
			User user = dao.get(Long.parseLong(session().get("user_id")));
			if (user == null) {
				throw new IllegalArgumentException("User not found.");
			} /*else if (user.getId() != userid) {
				throw new UnauthorizedException(
						"Not allowed to upload avatar image.");
			}*/ else {

				MultipartFormData body = request().body().asMultipartFormData();
				FilePart picture = body.getFile("file");
				if (picture != null) {
					File file = picture.getFile();
					String mime = picture.getContentType();
					Logger.debug("Avatar mime: " + mime);
					if(!mime.equals("image/jpeg") && !mime.equals("image/jpg") && !mime.equals("image/png") && !mime.equals("image/gif")) {
						throw new IllegalArgumentException("Unsupported filetype.");
					}
					
					BufferedImage bimg = ImageIO.read(file);
					int width          = bimg.getWidth();
					int height         = bimg.getHeight();
					Logger.debug("Avatar dimension: " + width + "x" + height);
					
					byte [] imageBytes = FileUtils.readFileToByteArray(file);
					int size = imageBytes.length;
					Logger.debug("Avatar size: " + size);
					
					if(width > 300 || height > 300) {
						throw new IllegalArgumentException("Unsupported image dimension (" + width + "x" + height + ").");						
					} else if(size > 1024 * 100) {
						throw new IllegalArgumentException("Unsupported image size ("+ size + ").");						
					}
					
					user.setAvatar(imageBytes);
					return ok();
				} else {
					throw new IllegalArgumentException("Missing image.");
				}
			}
		} /*catch (UnauthorizedException e) {
			return forbidden(e.getMessage());
		}*/ catch (IllegalArgumentException e) {
			return badRequest(e.getMessage());
		} catch (Exception e) {
			Logger.error("Avatar upload failed.", e);
			return internalServerError("Technical Error during avatar image upload");
		}
	}
}
