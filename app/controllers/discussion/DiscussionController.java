package controllers.discussion;

import models.discussion.Discussion;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class DiscussionController extends AbstractCRUDController<Discussion, Long> {
	
	@Inject
	public DiscussionController(@Named("DiscussionDAO") GenericDAO<Discussion, Long> dao) {
		super(dao);
	}

}
