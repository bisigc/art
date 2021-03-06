package controllers.discussion;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.discussion.Discussion;
import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link Discussion} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class DiscussionController extends AbstractCRUDController<Discussion, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("DiscussionDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public DiscussionController(@Named("DiscussionDAO") GenericDAO<Discussion, Long> dao) {
		super(dao);
	}

}
