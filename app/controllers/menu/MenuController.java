package controllers.menu;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;

import models.menu.Menuitem;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link Menuitem} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class MenuController extends AbstractCRUDController<Menuitem, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("MenuitemDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public MenuController(@Named("MenuitemDAO") GenericDAO<Menuitem, Long> dao) {
		super(dao);
	}
	
	/**
	 * Overwritten get All method with using custom query to prevent infinite loop selection
	 * due to hierarchical data structure.
	 * 
	 * @return HTTP result
	 */
	@Override
	@Transactional(readOnly=true)
	public Result getAll() {
		List<Menuitem> data;
		try {
			TypedQuery<Menuitem> query = JPA.em().createQuery("select a from " + dao.getModel().getSimpleName() + " a where a.name != :arg1 and a.menuitem = :arg2 order by ordering asc", dao.getModel());
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
