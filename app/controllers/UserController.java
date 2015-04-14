package controllers;

import java.util.List;

import models.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {
	
	@Transactional(readOnly=true)
	public static Result getUsers() {
		List<User> data = JPA.em().createQuery("select a from User a", User.class).getResultList();
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public static Result getUser(Long id) {
		User user = JPA.em().find(User.class, id);
		return user == null ? notFound() : ok(Json.toJson(user));
	}
	
	@Transactional
	public static Result createUser() {
		User user = Json.fromJson(request().body().asJson(), User.class);
	    JPA.em().persist(user);
	    User inserted = JPA.em().find(User.class, user.getId());
	    return created(Json.toJson(inserted));
	}
	
	@Transactional
	public static Result updateUser(Long id) {
		User user = Json.fromJson(request().body().asJson(), User.class);
	    JPA.em().merge(user);
	    User updated = JPA.em().find(User.class, user.getId());
	    return ok(Json.toJson(updated));
	}
	
	@Transactional
	public static Result deleteUser(Long id) {
		User user = JPA.em().find(User.class, id);
		JPA.em().remove(user);
		return noContent();
	}
}
