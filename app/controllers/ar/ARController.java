package controllers.ar;

import models.ar.ArchitecturalRefactoring;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link models.ar.ArchitecturalRefactoring} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class ARController extends AbstractCRUDController<ArchitecturalRefactoring, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("ArDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public ARController(@Named("ArDAO") GenericDAO<ArchitecturalRefactoring, Long> dao) {
		super(dao);
	}

}
