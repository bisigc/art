package controllers.property;

import java.util.List;

import javax.persistence.TypedQuery;

import models.property.Property;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link models.property.Property} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class PropertyController extends AbstractCRUDController<Property, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("PropertyDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public PropertyController(@Named("PropertyDAO") GenericDAO<Property, Long> dao) {
		super(dao);
	}
	
	/**
	 * Retrieves a list of {@link models.property.Property} Objects having the same
	 * categorie attribute.
	 * 
	 * @param cat
	 * @return
	 */
	@Transactional(readOnly=true)
	public Result getCategorie(String cat) {
		List<Property> data;
		try {
			TypedQuery<Property> query = JPA.em().createQuery("select a from Property a where a.categorie = :cat", Property.class);
			query.setParameter("cat", cat);
			data = dao.find(query);
		} catch (Exception e) {
			String msg = "Failed to get categorie of " + dao.getModel().getSimpleName();
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(data));
	}
}