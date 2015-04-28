package controllers.smell;

import java.sql.Timestamp;
import java.util.List;

import models.smell.Smell;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.actions.SessionAuth;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class SmellController extends AbstractCRUDController<Smell, Long> {
	
	@Inject
	public SmellController(@Named("SmellDAO") GenericDAO<Smell, Long> dao) {
		super(dao);
	}

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
		    smell.setWeight(1.0);
		    smell.setStatus(models.status.Status.draft);
		    smell.configQuestionParents();
			inserted = dao.create(smell);
		} catch (Exception e) {
			String msg =" Failed to create " + dao.getModel().getSimpleName() ;
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
	    return created(Json.toJson(inserted));
	}
	
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
