package controllers.task;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import models.task.ExecTaskType;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class ExecTaskTypeController extends AbstractCRUDController<ExecTaskType, Long> {
	
	@Inject
	public ExecTaskTypeController(@Named("ExecTaskTypeDAO") GenericDAO<ExecTaskType, Long> dao) {
		super(dao);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Result getAll() {
		TypedQuery<ExecTaskType> query = JPA.em().createQuery("select a from ExecTaskType a where a.name != :arg1 and a.parent = :arg2 order by ordering asc", ExecTaskType.class);
		query.setParameter("arg1", "root");
		ExecTaskType task = new ExecTaskType();
		task.setId(new Long(1));
		query.setParameter("arg2", task);
		List<ExecTaskType> data = query.getResultList();
		return ok(Json.toJson(data));
	}
	
	public Result getEmptyExecTaskType() {
		ExecTaskType task = new ExecTaskType();
		task.setSubTasks(new ArrayList<ExecTaskType>());
		task.setName("New Execution Task Type");
		task.setDescription("");
		task.setOrdering(0);
		return ok(Json.toJson(task));
	}
	
	@Override
	@Transactional
	public Result update() {
		//ExecTaskType task = Json.fromJson(request().body().asJson().get(0), ExecTaskType.class);
		ExecTaskType task = Json.fromJson(request().body().asJson().get(0), ExecTaskType.class);
		ExecTaskType parent = new ExecTaskType();
		parent.setId(Long.valueOf(1));
		task.setParent(parent);
		task.setParents();
	    ExecTaskType updated = dao.update(task);
	    return ok(Json.toJson(updated));
	}
}
