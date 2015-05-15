package controllers.ar;

import java.util.ArrayList;
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

import com.fasterxml.jackson.databind.JsonNode;
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
	

	private String arSmellSearchEndingPart = 
			"from " + dao.getModel().getSimpleName() + " a join a.smells s "
					+ "where a.status IN (:status) "
					+ "and s.id IN (:smellidlist) "
					+ "and a.created = "
					+ "(select max(c.created) from " + dao.getModel().getSimpleName() + " c join c.smells t "
							+ "where a.arhead.id = c.arhead.id and t.id IN (:smellidlist) and c.status IN (:status) ) order by a.name";

	private String arSmellSearchString = 
			"select a " + arSmellSearchEndingPart;
	
	private String arSmellSearchCountString = 
			"select count(a.id) " + arSmellSearchEndingPart;

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

	/**
	 * Returns the Ars for an Ar search with given smell ids.
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Result arSmellSearch() {
		List<Long> smellidlist = new ArrayList<Long>();
	    JsonNode node = null;
		List<ArVersion> data;
		try {
			node = request().body().asJson();
			//smellidlist = new ObjectMapper().readValue(node.asText(), new TypeReference<List<Integer>>(){});
			JsonNode array = node.get("smellids");
			//Iterator i = array.iterator();
			for (JsonNode jsonNode : array) {
				smellidlist.add(jsonNode.asLong());
			}
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
	
	/**
	 * Returns the count for an Ar search with given smell ids.
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Result arSmellSearchCount() {
		List<Long> smellidlist = new ArrayList<Long>();
	    JsonNode node = null;
		Integer data;
		try {
			node = request().body().asJson();
			//smellidlist = new ObjectMapper().readValue(node.asText(), new TypeReference<List<Integer>>(){});
			JsonNode array = node.get("smellids");
			//Iterator i = array.iterator();
			for (JsonNode jsonNode : array) {
				smellidlist.add(jsonNode.asLong());
			}
			TypedQuery<Long> query = JPA.em().createQuery(arSmellSearchCountString, Long.class);
			
			String rolename = session().get("role");
			List<ItemStatus> status;
			
			if("Admin".equals(rolename) || "Editor".equals(rolename)) {
				status = Arrays.asList(ItemStatus.values());
			} else {
				status = Arrays.asList(ItemStatus.published);
			}
			
			query.setParameter("status", status);
			query.setParameter("smellidlist", smellidlist);
			
			data = query.getSingleResult().intValue();
		} catch (Exception e) {
			String msg = "Failed to search count for " + dao.getModel().getSimpleName() + " with Smells";
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(String.valueOf(data));
	}
	
}
