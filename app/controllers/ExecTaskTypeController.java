package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import models.ExecTaskType;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class ExecTaskTypeController extends Controller {
	
	@Transactional(readOnly=true)
	public static Result getExecTaskTypes() {
		TypedQuery<ExecTaskType> query = JPA.em().createQuery("select a from ExecTaskType a where a.name != :arg1 and a.parent = :arg2 order by ordering asc", ExecTaskType.class);
		query.setParameter("arg1", "root");
		ExecTaskType task = new ExecTaskType();
		task.setId(new Long(1));
		query.setParameter("arg2", task);
		List<ExecTaskType> data = query.getResultList();
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public static Result getExecTaskType(Long id) {
		ExecTaskType task = JPA.em().find(ExecTaskType.class, id);
		return task == null ? notFound() : ok(Json.toJson(task));
	}
	
	public static Result getEmptyExecTaskType() {
		ExecTaskType task = new ExecTaskType();
		task.setSubTasks(new ArrayList<ExecTaskType>());
		task.setName("New Execution Task Type");
		task.setDescription("");
		task.setOrdering(0);
		return ok(Json.toJson(task));
	}
	
	@Transactional
	public static Result createExecTaskType() {
		ExecTaskType task = Json.fromJson(request().body().asJson(), ExecTaskType.class);
	    JPA.em().persist(task);
	    ExecTaskType inserted = JPA.em().find(ExecTaskType.class, task.getId());
	    return created(Json.toJson(inserted));
	}
	
	@Transactional
	public static Result updateExecTaskType(Long id) {
		//ExecTaskType task = Json.fromJson(request().body().asJson().get(0), ExecTaskType.class);
		ExecTaskType task = Json.fromJson(request().body().asJson().get(0), ExecTaskType.class);
		ExecTaskType parent = new ExecTaskType();
		parent.setId(Long.valueOf(1));
		task.setParent(parent);
		task.setParents();
	    JPA.em().merge(task);
	    ExecTaskType updated = JPA.em().find(ExecTaskType.class, task.getId());
	    return ok(Json.toJson(updated));
	}
	
	@Transactional
	public static Result deleteExecTaskType(Long id) {
		ExecTaskType task = JPA.em().find(ExecTaskType.class, id);
		JPA.em().remove(task);
		return noContent();
	}
}
