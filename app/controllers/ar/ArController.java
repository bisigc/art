package controllers.ar;

import java.sql.Timestamp;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.ar.Ar;
import models.discussion.Discussion;
import models.discussion.Discussion.DiscussionType;
import models.status.ItemStatus;
import models.user.User;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.actions.SessionAuth;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and
 * manipulate {@link models.ar.Ar} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class ArController extends AbstractCRUDController<Ar, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is
	 * "@Named("ArDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public ArController(@Named("ArDAO") GenericDAO<Ar, Long> dao) {
		super(dao);
	}
	
	/*@Override
	@Transactional(readOnly=true)
	public Result get(Long id) {
		Ar ar;
		try {
			TypedQuery<Ar> query =  JPA.em().createQuery("select a from " + dao.getModel().getSimpleName() + " a join a.versions v where a.id = v.arhead.id order by v.created desc", dao.getModel());
			ar = query.getSingleResult();
			if(ar == null) {
				throw new ItemNotFoundException("Ar not found.");
			}
		} catch (ItemNotFoundException e) {
			Logger.error(e.getMessage(), e);
			return notFound(e.getMessage());
		} catch (Exception e) {
			String msg = "Failed to get " + dao.getModel().getSimpleName() + " with id " + id;
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ar == null ? notFound() : ok(Json.toJson(ar));
	}*/
	
	@SessionAuth
	@Transactional
	@Override
	public Result create() {
	    Ar inserted;
	    JsonNode node = null;
		try {
			node = request().body().asJson();
			Ar ar = Json.fromJson(node, dao.getModel());
		    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		    ar.getVersions().get(0).setCreated(currentTime);
		    ar.getVersions().get(0).setModified(currentTime);
		    User creator = new User();
		    creator.setId(Long.parseLong(session().get("user_id")));
		    ar.getVersions().get(0).setUser(creator);
		    Discussion discussion = new Discussion();
		    discussion.setAr(ar.getVersions().get(0));
		    discussion.setCreated(currentTime);
		    discussion.setType(DiscussionType.DISCUSSION);
		    ar.getVersions().get(0).setDiscussion(discussion);
		    ar.getVersions().get(0).setStatus(ItemStatus.draft);
		    ar.getVersions().get(0).setArhead(ar);
			inserted = dao.create(ar);
		} catch (Exception e) {
			String msg =" Failed to create " + dao.getModel().getSimpleName() ;
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
	    return created(Json.toJson(inserted));
	}
}
