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

public class PropertyController extends AbstractCRUDController<Property, Long> {
	
	@Inject
	public PropertyController(@Named("PropertyDAO") GenericDAO<Property, Long> dao) {
		super(dao);
	}
	
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
