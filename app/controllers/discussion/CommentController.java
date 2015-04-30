package controllers.discussion;

import models.discussion.Comment;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link models.discussion.Comment} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
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

}
