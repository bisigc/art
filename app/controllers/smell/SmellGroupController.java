package controllers.smell;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.smell.SmellGroup;
import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link SmellGroupController} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class SmellGroupController extends AbstractCRUDController<SmellGroup, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("SmellGroupDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public SmellGroupController(@Named("SmellGroupDAO") GenericDAO<SmellGroup, Long> dao) {
		super(dao);
	}

}
