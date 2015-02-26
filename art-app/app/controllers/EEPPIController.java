package controllers;

import java.util.List;

import models.EEPPIData;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

public class EEPPIController extends Controller {

	// public static Result listAll() {
	// return ok(index.render("Your new application is ready."));
	// }

	public static Result listAll() {
		List<EEPPIData> data = EEPPIData.find.all();
		JsonNode node = Json.toJson(data);
		return ok(node);
	}
	
	public static Result add() {
		return ok();
	}
}
