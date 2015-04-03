package controllers;

import java.util.List;

import javax.persistence.TypedQuery;

import models.Menuitem;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class MenuController extends Controller {
	
	@Transactional(readOnly=true)
	public static Result getMenuitems() {
		TypedQuery<Menuitem> query = JPA.em().createQuery("select a from Menuitem a where a.name != :arg1 and a.menuitem = :arg2 order by ordering asc", Menuitem.class);
		query.setParameter("arg1", "root");
		Menuitem menu = new Menuitem();
		menu.setId(new Long(1));
		query.setParameter("arg2", menu);
		List<Menuitem> data = query.getResultList();
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public static Result getMenuitem(Long id) {
		Menuitem menu = JPA.em().find(Menuitem.class, id);
		return menu == null ? notFound() : ok(Json.toJson(menu));
	}
	
	@Transactional
	public static Result createMenuitem() {
		Menuitem menu = Json.fromJson(request().body().asJson(), Menuitem.class);
	    JPA.em().persist(menu);
	    Menuitem inserted = JPA.em().find(Menuitem.class, menu.getId());
	    return created(Json.toJson(inserted));
	}
	
	@Transactional
	public static Result updateMenuitem(Long id) {
		Menuitem menu = Json.fromJson(request().body().asJson(), Menuitem.class);
	    JPA.em().merge(menu);
	    Menuitem updated = JPA.em().find(Menuitem.class, menu.getId());
	    return ok(Json.toJson(updated));
	}
	
	@Transactional
	public static Result deleteMenuitem(Long id) {
		Menuitem menu = JPA.em().find(Menuitem.class, id);
		JPA.em().remove(menu);
		return noContent();
	}
}
