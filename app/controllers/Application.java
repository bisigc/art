package controllers;

import java.util.Base64;
import java.util.List;

import javax.persistence.TypedQuery;

import models.user.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.exceptions.NoSessionException;
import views.html.index;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import dao.GenericDAO;

public class Application extends Controller {
	
	protected GenericDAO<User, Long> dao;
	
	@Inject
	public Application(@Named("UserDAO") GenericDAO<User, Long> dao) {
		this.dao = dao;
	}

	@Transactional(readOnly=true)
	public Result index() {
		String activeProfile = new String(Base64.getEncoder().encode(checkLogin().getBytes()));
		return ok(index.render(activeProfile));
//		return ok(list.render());
	}
	
	
	public String checkLogin() {
		User user;
		try {
			String email = session().get("email");
			if(null == email) {
				throw new NoSessionException("No session");
			}
			TypedQuery<User> query = JPA.em().createQuery(
				"select a from User a where a.email = :email", User.class);
			query.setParameter("email", email);
			List<User> data = dao.find(query);
			user = data.get(0);
		} catch (Exception e) {
			return "";
		}
		return Json.toJson(user).toString();
	}
}
