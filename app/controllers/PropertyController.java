package controllers;

import java.util.List;

import models.Property;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class PropertyController extends Controller {

	public static Result getAllProperties() {
		List<Property> data = Property.find.all();
		return ok(Json.toJson(data));
	}
	
	public static Result getProperties(String cat) {
		List<Property> data = Property.find.where().eq("categorie", cat).findList();
		return ok(Json.toJson(data));
	}
	
	public static Result getProperty(Long id) {
		Property prop = Property.find.byId(id);
		return prop == null ? notFound() : ok(Json.toJson(prop));
	}
	
	public static Result createProperty() {
	    Property prop = Json.fromJson(request().body().asJson(), Property.class);
	    prop.save();
	    Property inserted = Property.find.byId(prop.getId());
	    return created(Json.toJson(inserted));
	}
	
	public static Result updateProperty(Long id) {
	    Property prop = Json.fromJson(request().body().asJson(), Property.class);
	    prop.update(id);
	    Property updated = Property.find.byId(prop.getId());
	    return ok(Json.toJson(updated));
	}
	
	public static Result deleteProperty(Long id) {
		Property.find.byId(id).delete();
	    return noContent();
	}
}
