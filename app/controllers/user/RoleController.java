package controllers.user;

import models.user.Role;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link Role} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class RoleController extends AbstractCRUDController<Role, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("RoleDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public RoleController(@Named("RoleDAO") GenericDAO<Role, Long> dao) {
		super(dao);
	}

}
