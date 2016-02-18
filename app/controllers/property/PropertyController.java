package controllers.property;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;

import controllers.AbstractCRUDController;
import dao.GenericDAO;
import models.property.Property;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link models.property.Property} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class PropertyController extends AbstractCRUDController<Property, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("PropertyDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public PropertyController(@Named("PropertyDAO") GenericDAO<Property, Long> dao) {
		super(dao);
	}
	
	/**
	 * Retrieves a list of {@link models.property.Property} Objects having the same
	 * categorie attribute.
	 * 
	 * @param cat categorie String
	 * @param lang language String
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	//@Cached(key="PopertyCats")
	public Result getCategorie(String cat, String lang) {
		List<Property> data;
		if(lang == null || lang.equals("")) {
			lang = "en";
		}
		try {
			TypedQuery<Property> query = JPA.em().createQuery("select a from Property a where a.categorie = :cat and a.language = :lang", Property.class);
			query.setParameter("cat", cat);
			query.setParameter("lang", lang);
			data = dao.find(query);
		} catch (Exception e) {
			String msg = "Failed to get categorie of " + dao.getModel().getSimpleName();
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(data));
	}
}
