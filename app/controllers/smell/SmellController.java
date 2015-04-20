package controllers.smell;

import java.sql.Timestamp;
import java.util.List;

import models.Smell;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

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
		List<Smell> data = dao.getAll();
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

	@Override
	@Transactional
	public Result create() {
	    Smell smell = Json.fromJson(request().body().asJson(), dao.getModel());
	    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	    smell.setCreated(currentTime);
	    smell.setModified(currentTime);
	    smell.setWeight(1.0);
	    smell.setStatus(models.Status.draft);
	    smell.configQuestionParents();
	    Smell inserted = dao.create(smell);
	    return created(Json.toJson(inserted));
	}
	
	@Override
	@Transactional
	public Result update() {
		Smell smell = Json.fromJson(request().body().asJson(), dao.getModel());
	    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	    smell.setModified(currentTime);
	    smell.configQuestionParents();
	    return ok(Json.toJson(dao.update(smell)));
	}
}
