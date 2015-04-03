package controllers;

import java.util.List;

import javax.persistence.TypedQuery;

import models.Property;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class PropertyController extends Controller {

	@Transactional(readOnly=true)
	public static Result getAllProperties() {
		List<Property> data = JPA.em().createQuery("select a from Property a", Property.class).getResultList();
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public static Result getProperties(String cat) {
		TypedQuery<Property> query = JPA.em().createQuery("select a from Property a where a.categorie = :cat", Property.class);
		query.setParameter("cat", cat);
		List<Property> data = query.getResultList();
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public static Result getProperty(Long id) {
		Property prop = JPA.em().find(Property.class, id);
		return prop == null ? notFound() : ok(Json.toJson(prop));
	}
	
	@Transactional
	public static Result createProperty() {
	    Property prop = Json.fromJson(request().body().asJson(), Property.class);
	    JPA.em().persist(prop);
	    Property inserted = JPA.em().find(Property.class, prop.getId());
	    return created(Json.toJson(inserted));
	}
	
	@Transactional
	public static Result updateProperty(Long id) {
	    Property prop = Json.fromJson(request().body().asJson(), Property.class);
	    JPA.em().merge(prop);
	    Property updated = JPA.em().find(Property.class, prop.getId());
	    return ok(Json.toJson(updated));
	}
	
	@Transactional
	public static Result deleteProperty(Long id) {
		Property prop = JPA.em().find(Property.class, id);
		JPA.em().remove(prop);
	    return noContent();
	}
}
