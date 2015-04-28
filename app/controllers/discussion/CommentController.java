package controllers.discussion;

import models.discussion.Comment;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class CommentController extends AbstractCRUDController<Comment, Long> {
	
	@Inject
	public CommentController(@Named("CommentDAO") GenericDAO<Comment, Long> dao) {
		super(dao);
	}

}
