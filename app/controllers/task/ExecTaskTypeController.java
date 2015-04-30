package controllers.task;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import models.task.ExecTaskType;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import utils.actions.SessionAuth;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link ExecTaskType} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class ExecTaskTypeController extends AbstractCRUDController<ExecTaskType, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("ExecTaskTypeDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public ExecTaskTypeController(@Named("ExecTaskTypeDAO") GenericDAO<ExecTaskType, Long> dao) {
		super(dao);
	}
	
	/**
	 * Overwritten get All method with using custom query to prevent infinite loop selection
	 * due to hierarchical data structure.
	 * 
	 * @return
	 */
	@Override
	@Transactional(readOnly=true)
	public Result getAll() {
		List<ExecTaskType> data;
		try {
			TypedQuery<ExecTaskType> query = JPA.em().createQuery("select a from ExecTaskType a where a.name != :arg1 and a.parent = :arg2 order by ordering asc", ExecTaskType.class);
			query.setParameter("arg1", "root");
			ExecTaskType task = new ExecTaskType();
			task.setId(new Long(1));
			query.setParameter("arg2", task);
			data = dao.find(query);
		} catch (Exception e) {
			String msg = "Failed to get All " + dao.getModel().getSimpleName();
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(data));
	}
	
	/**
	 * Delivers an empty JsonNode object with the structure of a {@link ExecTaskType} object.
	 * 
	 * @return
	 */
	public Result getEmptyExecTaskType() {
		ExecTaskType task = new ExecTaskType();
		task.setSubTasks(new ArrayList<ExecTaskType>());
		task.setName("New Execution Task Type");
		task.setDescription("");
		task.setOrdering(0);
		return ok(Json.toJson(task));
	}
	
	/**
	 * Overwritten update method to update the hierarchical data tree of {@link ExecTaskType}.
	 * @see controllers.AbstractCRUDController#update()
	 */
	@SessionAuth
	@Override
	@Transactional
	public Result update() {
		//ExecTaskType task = Json.fromJson(request().body().asJson().get(0), ExecTaskType.class);
	    ExecTaskType updated;
	    JsonNode node = null;
		try {
			node = request().body().asJson().get(0);
			ExecTaskType task = Json.fromJson(node, ExecTaskType.class);
			ExecTaskType parent = new ExecTaskType();
			parent.setId(Long.valueOf(1));
			task.setParent(parent);
			task.setParents();
			updated = dao.update(task);
		} catch (Exception e) {
			String msg = "Failed to update " + dao.getModel().getSimpleName();
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
	    return ok(Json.toJson(updated));
	}
}
