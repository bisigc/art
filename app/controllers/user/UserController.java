package controllers.user;

import java.security.GeneralSecurityException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.security.auth.login.FailedLoginException;

import models.user.Login;
import models.user.NewPassword;
import models.user.User;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.actions.SessionAuth;
import utils.crypto.Crypto;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link User} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class UserController extends AbstractCRUDController<User, Long> {

	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("UserDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public UserController(@Named("UserDAO") GenericDAO<User, Long> dao) {
		super(dao);
	}

	/**
	 * Processes a login request. Retrieving username (email) and password via a JsonNode.
	 * Validates username and password, creates user session and returns the {@link User} object
	 * as a JsonNode.
	 * 
	 * @return
	 */
	@Transactional(readOnly=true)
	public Result login() {
		Login login = Json.fromJson(request().body().asJson(), Login.class);
		TypedQuery<User> query = JPA.em().createQuery(
				"select a from User a where a.email = :email", User.class);
		query.setParameter("email", login.getEmail());
		User user;
		try {
			List<User> data = dao.find(query);
			if (null == data) {
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
	 * @return
	 */
	public Result logout() {
		session().clear();
		return ok();
	}
	
	/**
	 * changePassword Method receives the current password, the new password and
	 * a repetition of the new password. The current password is being checked
	 * and if the new password is the same as its repetition, it is saved via the {@link GenericDAO}
	 * object. 
	 * 
	 * @return
	 */
	@SessionAuth
	@Transactional
	public Result changePassword() {
		NewPassword pw = Json.fromJson(request().body().asJson(), NewPassword.class);
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
				if(pw.getNewpassword().equals(pw.getRepeatpassword())){
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
}
