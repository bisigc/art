package controllers.smell;

import models.smell.SmellGroup;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link SmellGroupController} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class SmellGroupController extends AbstractCRUDController<SmellGroup, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("SmellGroupDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public SmellGroupController(@Named("SmellGroupDAO") GenericDAO<SmellGroup, Long> dao) {
		super(dao);
	}

}
