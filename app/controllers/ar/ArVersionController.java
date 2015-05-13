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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link models.ar.ArVersion} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class ArVersionController extends AbstractCRUDController<ArVersion, Long> {
	
	private String getAllQueryString = 
			"select a from " + dao.getModel().getSimpleName() + " a where a.status IN (:status) and a.created = (select max(c.created) from " + dao.getModel().getSimpleName() + " c where a.arhead.id = c.arhead.id and c.status IN (:status) ) order by a.name";
	

	private String arSmellSearchEndingPart = "from " + dao.getModel().getSimpleName() + " a where a.status IN (:status) and a.smell_id IN (:smellidlist) and a.created = (select max(c.created) from " + dao.getModel().getSimpleName() + " c where a.arhead.id = c.arhead.id and  and c.smell_id IN (:smellidlist) c.status IN (:status) ) order by a.name";

	private String arSmellSearchString = 
			"select a " + arSmellSearchEndingPart;
	
	private String arSmellSearchCountString = 
			"select count(a) " + arSmellSearchEndingPart;

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

	@Transactional(readOnly = true)
	public Result arSmellSearch() {
		List<Integer> smellidlist;
	    String node = null;
		List<ArVersion> data;
		try {
			node = request().body().asText();
			smellidlist = new ObjectMapper().readValue(node, new TypeReference<List<Integer>>(){});
			TypedQuery<ArVersion> query = JPA.em().createQuery(arSmellSearchString, ArVersion.class);
			
			String rolename = session().get("role");
			List<ItemStatus> status;
			
			if("Admin".equals(rolename) || "Editor".equals(rolename)) {
				status = Arrays.asList(ItemStatus.values());
			} else {
				status = Arrays.asList(ItemStatus.published);
			}
			
			query.setParameter("status", status);
			query.setParameter("smellidlist", smellidlist);

			data = dao.find(query);
		} catch (Exception e) {
			String msg = "Failed to search for " + dao.getModel().getSimpleName() + " with Smells";
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly = true)
	public Result arSmellSearchCount() {
		List<Integer> smellidlist;
	    String node = null;
		Integer data;
		try {
			node = request().body().asText();
			Logger.error("Node: " + node);
			smellidlist = new ObjectMapper().readValue(node, new TypeReference<List<Integer>>(){});
			TypedQuery<Integer> query = JPA.em().createQuery(arSmellSearchCountString, Integer.class);
			
			String rolename = session().get("role");
			List<ItemStatus> status;
			
			if("Admin".equals(rolename) || "Editor".equals(rolename)) {
				status = Arrays.asList(ItemStatus.values());
			} else {
				status = Arrays.asList(ItemStatus.published);
			}
			
			query.setParameter("status", status);
			query.setParameter("smellidlist", smellidlist);
			
			data = query.getSingleResult();
		} catch (Exception e) {
			String msg = "Failed to search for " + dao.getModel().getSimpleName() + " with Smells";
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(String.valueOf(data));
	}
	
}
