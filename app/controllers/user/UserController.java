package controllers.user;

import models.User;
import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class UserController extends AbstractCRUDController<User, Long> {
	
	public UserController(GenericDAO<User, Long> dao) {
		this.dao = dao;
	}

}
