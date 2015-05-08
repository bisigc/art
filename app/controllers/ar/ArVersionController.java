package controllers.ar;

import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;

import models.ar.ArVersion;
import models.status.ItemStatus;
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
 * {@link models.ar.ArVersion} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class ArVersionController extends AbstractCRUDController<ArVersion, Long> {
	
	private String getAllQueryString = 
			"select a from " + dao.getModel().getSimpleName() + " a where a.status IN (:status) and a.created = (select max(c.created) from " + dao.getModel().getSimpleName() + " c where a.arhead.id = c.arhead.id and c.status IN (:status) ) order by a.name";
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("ArVersionDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public ArVersionController(@Named("ArVersionDAO") GenericDAO<ArVersion, Long> dao) {
		super(dao);
	}
	
	/**
	 * Provides all active ArVersions.
	 * 
	 * @return HTTP result
	 */
	@Override
	@Transactional(readOnly=true)
	public Result getAll() {
		List<ArVersion> data;
		try {
			String rolename = session().get("role");
			TypedQuery<ArVersion> query = JPA.em().createQuery(getAllQueryString, ArVersion.class);
			List<ItemStatus> status;

			if("Admin".equals(rolename) || "Editor".equals(rolename)) {
				status = Arrays.asList(ItemStatus.values());
			} else {
				status = Arrays.asList(ItemStatus.published);
			}

			query.setParameter("status", status);
			data = dao.find(query);
		} catch (Exception e) {
			String msg = "Failed to get All active " + dao.getModel().getSimpleName();
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(data));
	}

}
