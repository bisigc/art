package controllers.discussion;

import java.sql.Timestamp;

import models.discussion.Comment;
import models.user.User;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.actions.SessionAuth;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link models.discussion.Comment} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class CommentController extends AbstractCRUDController<Comment, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("CommentDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public CommentController(@Named("CommentDAO") GenericDAO<Comment, Long> dao) {
		super(dao);
	}

	@SessionAuth
	@Transactional
	@Override
	public Result create() {
	    Comment inserted;
	    JsonNode node = null;
		try {
			node = request().body().asJson();
			Comment comment = Json.fromJson(node, dao.getModel());
		    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		    comment.setCreated(currentTime);
		    comment.setModified(currentTime);
		    User creator = new User();
		    creator.setId(Long.parseLong(session().get("user_id")));
		    comment.setUser(creator);
			inserted = dao.create(comment);
		} catch (Exception e) {
			String msg =" Failed to create " + dao.getModel().getSimpleName() ;
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
	    return created(Json.toJson(inserted));
	}

}
