package controllers.ar;

import java.util.List;

import javax.persistence.TypedQuery;

import models.ar.ArSearch;
import models.user.User;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.actions.SessionAuth;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link models.ar.ArSearch} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class ArSearchController extends AbstractCRUDController<ArSearch, Long> {
	
	private String getUsersSearches = 
			"select a from " + dao.getModel().getSimpleName() + " a where a.user = :user order by a.name";
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("ArSearchDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public ArSearchController(@Named("ArSearchDAO") GenericDAO<ArSearch, Long> dao) {
		super(dao);
	}
	
	/**
	 * Provides all User ArSearches.
	 * 
	 * @return HTTP result
	 */
	@SessionAuth
	@Transactional(readOnly=true)
	public Result getUserSearches() {
		List<ArSearch> data;
		try {
			Long userid = Long.valueOf(session().get("user_id"));
			TypedQuery<ArSearch> query = JPA.em().createQuery(getUsersSearches, ArSearch.class);
			
			User user = new User();
			user.setId(userid);

			query.setParameter("user", user);
			data = dao.find(query);
		} catch (Exception e) {
			String msg = "Failed to get users " + dao.getModel().getSimpleName();
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(data));
	}
	
	@SessionAuth
	@Transactional
	@Override
	public Result create() {
	    ArSearch inserted;
	    JsonNode node = null;
		try {
			node = request().body().asJson();
			ArSearch search = Json.fromJson(node, dao.getModel());
		    User user = new User();
		    user.setId(Long.parseLong(session().get("user_id")));
		    search.setUser(user);
			inserted = dao.create(search);
		} catch (Exception e) {
			String msg =" Failed to create " + dao.getModel().getSimpleName() ;
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
	    return created(Json.toJson(inserted));
	}
}
