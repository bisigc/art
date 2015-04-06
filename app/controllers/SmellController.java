package controllers;

import java.sql.Timestamp;
import java.util.List;

import models.Smell;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

public class SmellController extends Controller {

	@Transactional(readOnly=true)
	public static Result getAllSmells() {
		List<Smell> data = JPA.em().createQuery("select a from Smell a", Smell.class).getResultList();
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public static Result getCloudSmells() {
		List<Smell> data = JPA.em().createQuery("select a from Smell a", Smell.class).getResultList();
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
	    System.out.println(buf);
	    return ok(buf.toString()).as("application/json");
	}
	
	@Transactional(readOnly=true)
	public static Result getSmell(Long id) {
		Smell smell = JPA.em().find(Smell.class, id);
		return smell == null ? notFound() : ok(Json.toJson(smell));
	}
	
	@Transactional
	public static Result createSmell() {
	    Smell newSmell = Json.fromJson(request().body().asJson(), Smell.class);
	    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	    newSmell.setCreated(currentTime);
	    newSmell.setModified(currentTime);
	    newSmell.setWeight(1.0);
	    JPA.em().persist(newSmell);
	    Smell inserted = JPA.em().find(Smell.class, newSmell.getId());
	    return created(Json.toJson(inserted));
	}
	
	@Transactional
	public static Result updateSmell(Long id) {
	    Smell smell = Json.fromJson(request().body().asJson(), Smell.class);
	    JPA.em().merge(smell);
	    Smell updated = JPA.em().find(Smell.class, smell.getId());
	    return ok(Json.toJson(updated));
	}
	
	@Transactional
	public static Result deleteSmell(Long id) {
	    Smell smell = JPA.em().find(Smell.class, id);
		JPA.em().remove(smell);
	    return noContent();
	}
}
