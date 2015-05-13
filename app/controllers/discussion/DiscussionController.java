package controllers.discussion;

import models.discussion.Discussion;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

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
	 * @param dao
	 */
	@Inject
	public DiscussionController(@Named("DiscussionDAO") GenericDAO<Discussion, Long> dao) {
		super(dao);
	}

}
