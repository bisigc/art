package controllers.status;

import models.status.ItemStatus;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.inject.Singleton;

/**
 * Extends the general class {@link play.mvc.Controller}. Contains one method which
 * returns all values of the Enum {@link models.status.ItemStatus} as a JsonNode.
 * Is annotated with {@link com.google.inject.Singleton}, which makes sure
 * the DI framework creates only one instance of the class.
 * 
 * @author cbi
 */
@Singleton
public class StatusController extends Controller {
	
	/**
	 * Returns all values of the Enum {@link models.status.ItemStatus} as a JsonNode.
	 * 
	 * @return
	 */
	public Result get() {
		return ok(Json.toJson(ItemStatus.values()));
	}
}
