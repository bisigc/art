package controllers;

import java.util.List;

import models.Menuitem;
import models.Property;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class MenuController extends Controller {
	
	public static Result getMenuitems() {
		List<Menuitem> data = Menuitem.find.where().ne("name", "root").eq("menuitem_id", 1).orderBy("ordering").findList();
		return ok(Json.toJson(data));
	}
	
	public static Result getMenuitem(Long id) {
		Menuitem prop = Menuitem.find.byId(id);
		return prop == null ? notFound() : ok(Json.toJson(prop));
	}
	
	public static Result createMenuitem() {
		Menuitem menu = Json.fromJson(request().body().asJson(), Menuitem.class);
	    menu.save();
	    Menuitem inserted = Menuitem.find.byId(menu.getId());
	    return created(Json.toJson(inserted));
	}
	
	public static Result updateMenuitem(Long id) {
		Menuitem menu = Json.fromJson(request().body().asJson(), Menuitem.class);
	    menu.update(id);
	    Property updated = Property.find.byId(menu.getId());
	    return ok(Json.toJson(updated));
	}
	
	public static Result deleteMenuitem(Long id) {
		Menuitem.find.byId(id).delete();
	    return noContent();
	}
}
