package controllers.status;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class StatusController extends Controller {
	
	public Result get() {
		return ok(Json.toJson(models.Status.values()));
	}
}
