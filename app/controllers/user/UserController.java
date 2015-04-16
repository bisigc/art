package controllers.user;

import models.User;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class UserController extends AbstractCRUDController<User, Long> {
	
	@Inject
	public UserController(@Named("UserDAO") GenericDAO<User, Long> dao) {
		super(dao);
	}

}
