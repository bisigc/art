package controllers.user;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.user.Role;
import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link Role} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class RoleController extends AbstractCRUDController<Role, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("RoleDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public RoleController(@Named("RoleDAO") GenericDAO<Role, Long> dao) {
		super(dao);
	}

}
