package controllers.discussion;

import javax.persistence.PersistenceException;

import models.discussion.Comment;
import models.discussion.Likeing;
import models.user.User;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Result;
import play.mvc.Results;
import utils.actions.SessionAuth;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link models.discussion.Likeing} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class LikeController extends AbstractCRUDController<Likeing, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("LikeingDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public LikeController(@Named("LikeingDAO") GenericDAO<Likeing, Long> dao) {
		super(dao);
	}

	@SessionAuth
	@Transactional
	public Result like(Long id) {
		try {
			Long userid = Long.parseLong(session().get("user_id"));
			User user = new User();
			user.setId(userid);
			
			Comment comment = new Comment();
			comment.setId(id);
			
			Likeing newLike = new Likeing();
			newLike.setComment(comment);
			newLike.setUser(user);
		
			JPA.em().persist(newLike);
		
		} catch(PersistenceException e) {
			return Results.status(CONFLICT, "You have already liked this.");
		} catch (Exception e) {
			String msg =" Failed to create " + dao.getModel().getSimpleName() ;
			Logger.error(msg, e);
			return internalServerError(msg);
		}
	    return ok();
	}

}
