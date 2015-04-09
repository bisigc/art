package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class StatusController extends Controller {
	
	public static Result getStatus() {
		return ok(Json.toJson(models.Status.values()));
	}
}
