package controllers;

import java.util.Base64;
import java.util.List;

import javax.persistence.TypedQuery;

import models.user.User;
import play.Configuration;
import play.Play;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.exceptions.NoSessionException;
import utils.exceptions.SessionTimeoutException;
import views.html.index;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import dao.GenericDAO;

@Singleton
public class Application extends Controller {
	
	protected GenericDAO<User, Long> dao;
	private static Configuration CONF = Play.application().configuration();
	private static long timeout = Long.parseLong(CONF.getString("default.sessiontimeout")) * 60 * 1000;

	
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
			} else {
				long time = Long.parseLong(session().get("time"));
				long currenttime = System.currentTimeMillis();
				long sessiontime = currenttime - time;
			
				if(sessiontime > timeout) {
					session().clear();
					throw new SessionTimeoutException("Session timeout");
				} /*else {
					session("time", Long.toString(currenttime));
				}*/
			}
			TypedQuery<User> query = JPA.em().createQuery(
				"select a from User a where a.email = :email", User.class);
			query.setParameter("email", email);
			List<User> data = dao.find(query);
			user = data.get(0);
		} catch (SessionTimeoutException e) {
			return e.getMessage();
		} catch (Exception e) {
			return "";
		}
		return Json.toJson(user).toString();
	}
}
