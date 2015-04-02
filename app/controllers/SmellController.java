package controllers;

import java.sql.Timestamp;
import java.util.List;

import models.Smell;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class SmellController extends Controller {

	// public static Result listAll() {
	// return ok(index.render("Your new application is ready."));
	// }

	public static Result getAllSmells() {
		List<Smell> data = Smell.find.all();
		return ok(Json.toJson(data));
		//return ok(Json.parse("['name':'Wert1']"));
	}
	
	public static Result getCloudSmells() {
		List<Smell> data = Smell.find.all();
		StringBuffer buf = new StringBuffer("[");
		for (Smell smell : data) {
			buf.append("{\"text\": \"");
			buf.append(smell.getName());
			buf.append("\", \"weight\": ");
			buf.append(smell.getWeight());
			buf.append(",    \"handlers\": { \"click\": \"function(){setSmell('");
			buf.append(smell.getName());
			buf.append("');}\" }},");
		}
		buf.delete(buf.length()-1, buf.length());
	    buf.append("]");
	    System.out.println(buf);
//	    return ok(Json.parse(buf.toString()));
	    return ok(Json.parse(buf.toString()));
	}
	
	public static Result getSmell(Long id) {
		Smell smell = Smell.find.byId(id);
		return smell == null ? notFound() : ok(Json.toJson(smell));
	}
	
	public static Result createSmell() {
	    Smell newSmell = Json.fromJson(request().body().asJson(), Smell.class);
	    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	    newSmell.setCreated(currentTime);
	    newSmell.setModified(currentTime);
	    newSmell.setWeight(1.0);
	    newSmell.save();
	    Smell inserted = Smell.find.byId(newSmell.getId());
	    return created(Json.toJson(inserted));
	}
	
	public static Result updateSmell(Long id) {
	    Smell smell = Json.fromJson(request().body().asJson(), Smell.class);
	    smell.update(id);
	    Smell updated = Smell.find.byId(smell.getId());
	    return ok(Json.toJson(updated));
	}
	
	public static Result deleteSmell(Long id) {
	    Smell.find.byId(id).delete();
	    return noContent();
	}
}
