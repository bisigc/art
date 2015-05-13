package controllers.ar;

import models.ar.Ar;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and
 * manipulate {@link models.ar.Ar} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class ArController extends AbstractCRUDController<Ar, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is
	 * "@Named("ArDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public ArController(@Named("ArDAO") GenericDAO<Ar, Long> dao) {
		super(dao);
	}
}
