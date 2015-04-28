package controllers.menu;

import java.util.List;

import javax.persistence.TypedQuery;

import models.menu.Menuitem;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class MenuController extends AbstractCRUDController<Menuitem, Long> {
	
	@Inject
	public MenuController(@Named("MenuitemDAO") GenericDAO<Menuitem, Long> dao) {
		super(dao);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Result getAll() {
		List<Menuitem> data;
		try {
			TypedQuery<Menuitem> query = JPA.em().createQuery("select a from Menuitem a where a.name != :arg1 and a.menuitem = :arg2 order by ordering asc", Menuitem.class);
			query.setParameter("arg1", "root");
			Menuitem menu = new Menuitem();
			menu.setId(new Long(1));
			query.setParameter("arg2", menu);
			data = dao.find(query);
		} catch (Exception e) {
			String msg = "Failed to get All " + dao.getModel().getSimpleName();
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(data));
	}
}
