package controllers.smell;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.AbstractCRUDController;
import dao.GenericDAO;
import models.smell.SmellGroup;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.actions.SessionAuth;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link SmellGroupController} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class SmellGroupController extends AbstractCRUDController<SmellGroup, Long> {

	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("SmellGroupDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public SmellGroupController(@Named("SmellGroupDAO") GenericDAO<SmellGroup, Long> dao) {
		super(dao);
	}
	
	/**
	 * Overwritten updated method, saves changes of a {@link SmellGroup} object which has been
	 * deserialized from the delivered JsonNode object, via the {@link GenericDAO} object.
	 * 
	 * @see controllers.AbstractCRUDController#update()
	 */
	@SessionAuth
	@Override
	@Transactional
	public Result update() {
		SmellGroup updated;
		JsonNode node = null;
		try {
			node = request().body().asJson();
			SmellGroup smellgroup = Json.fromJson(node, dao.getModel());
			SmellGroup toupdate = dao.get(smellgroup.getId());
			toupdate.setName(smellgroup.getName());
			toupdate.setDescription(smellgroup.getDescription());
		    updated = dao.update(toupdate);
		} catch (Exception e) {
			String msg = "Failed to update " + dao.getModel().getSimpleName();
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(updated));
	}
}
