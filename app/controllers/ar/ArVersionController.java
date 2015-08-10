package controllers.ar;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;

import models.ar.ArVersion;
import models.discussion.Discussion;
import models.discussion.Discussion.DiscussionType;
import models.status.ItemStatus;
import models.user.User;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.actions.SessionAuth;

import com.fasterxml.jackson.databind.JsonNode;

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
							+ "where a.arhead.id = c.arhead.id and t.id IN (:smellidlist) and c.status IN (:status) ) ";
	private String order = "order by a.name";

	private String arSmellSearchString = 
			"select a " + arSmellSearchEndingPart + order;
	
	private String arSmellSearchCountString = 
			"select count(a.id) " + arSmellSearchEndingPart;

	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("ArVersionDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public ArVersionController(@Named("ArVersionDAO") GenericDAO<ArVersion, Long> dao) {
		super(dao);
	}
	
	@SessionAuth
	@Transactional
	@Override
	public Result create() {
	    ArVersion inserted;
	    JsonNode node = null;
		try {
			node = request().body().asJson();
			ArVersion arversion = Json.fromJson(node, dao.getModel());
		    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		    arversion.setCreated(currentTime);
		    arversion.setModified(currentTime);
		    User creator = new User();
		    creator.setId(Long.parseLong(session().get("user_id")));
		    arversion.setUser(creator);
		    Discussion discussion = new Discussion();
		    discussion.setAr(arversion);
		    discussion.setCreated(currentTime);
		    discussion.setType(DiscussionType.DISCUSSION);
		    arversion.setDiscussion(discussion);
		    arversion.setStatus(ItemStatus.draft);
			inserted = dao.create(arversion);
		} catch (Exception e) {
			String msg =" Failed to create " + dao.getModel().getSimpleName() ;
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
	    return created(Json.toJson(inserted));
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
	 * @return HTTP result
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
	 * @return HTTP result
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
