package controllers.user;

import models.user.Role;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class RoleController extends AbstractCRUDController<Role, Long> {
	
	@Inject
	public RoleController(@Named("RoleDAO") GenericDAO<Role, Long> dao) {
		super(dao);
	}

}
