package controllers.smell;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.smell.Smell;
import models.status.ItemStatus;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.actions.SessionAuth;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link Smell} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class SmellController extends AbstractCRUDController<Smell, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("SmellDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public SmellController(@Named("SmellDAO") GenericDAO<Smell, Long> dao) {
		super(dao);
	}

	/**
	 * Returns a string which can be interpreted as a Javascript Object (user function eval()). The
	 * Javascript Object then contains a list of all {@link Smell} Objects in the format used as input 
	 * for jcloud (Open Source Tag Cloud Library). 
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getCloudSmells() {
		List<Smell> data;
		try {
			data = dao.getAll();
		} catch (Exception e) {
			String msg = "Failed to get all " + dao.getModel().getSimpleName() + " for cloud.";
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		StringBuffer buf = new StringBuffer("[");
		for (Smell smell : data) {
			buf.append("{\"text\":\"");
			buf.append(smell.getName());
			buf.append("\",\"weight\":");
			buf.append(smell.getWeight());
			buf.append(",\"handlers\":{\"click\":function(){setSmell('");
			buf.append(smell.getName());
			buf.append("');}}},");
		}
		
		// remove last "," but only if there where smells found.
		if(data.size() > 0) {
			buf.delete(buf.length()-1, buf.length());
		}
		
	    buf.append("]");
	    return ok(buf.toString());
	}

	/**
	 * Overwritten create method, which creates a new {@link Smell} object which has been
	 * deserialized from the delivered JsonNode object, via the {@link GenericDAO} object.
	 * 
	 * @see controllers.AbstractCRUDController#create()
	 */
	@SessionAuth
	@Override
	@Transactional
	public Result create() {
	    Smell inserted;
	    JsonNode node = null;
		try {
			node = request().body().asJson();
		    Smell smell = Json.fromJson(node, dao.getModel());
		    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		    smell.setCreated(currentTime);
		    smell.setModified(currentTime);
		    smell.setWeight(0);
		    smell.setStatus(ItemStatus.draft);
		    smell.configQuestionParents();
			inserted = dao.create(smell);
		} catch (Exception e) {
			String msg =" Failed to create " + dao.getModel().getSimpleName() ;
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
	    return created(Json.toJson(inserted));
	}
	
	/**
	 * Overwritten updated method, saves changes of a {@link Smell} object which has been
	 * deserialized from the delivered JsonNode object, via the {@link GenericDAO} object.
	 * 
	 * @see controllers.AbstractCRUDController#update()
	 */
	@SessionAuth
	@Override
	@Transactional
	public Result update() {
		Smell updated;
		JsonNode node = null;
		try {
			node = request().body().asJson();
			Smell smell = Json.fromJson(node, dao.getModel());
		    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		    smell.setModified(currentTime);
		    smell.configQuestionParents();
		    updated = dao.update(smell);
		} catch (Exception e) {
			String msg = "Failed to update " + dao.getModel().getSimpleName();
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(updated));
	}
}
