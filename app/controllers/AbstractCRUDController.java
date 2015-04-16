package controllers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import dao.GenericDAO;

public abstract class AbstractCRUDController<T, PK extends Serializable> extends Controller {
	
	protected GenericDAO<T, PK> dao;
	
	public AbstractCRUDController(GenericDAO<T, PK> dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly=true)
	public Result find(TypedQuery<T> query) {
		List<T> data = dao.find(query);
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public Result getAll() {
		List<T> data = dao.getAll();
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public Result get(PK id) {
		T t = dao.get(id);
		return t == null ? notFound() : ok(Json.toJson(t));
	}
	
	@Transactional
	public Result create() {
		T t = Json.fromJson(request().body().asJson(), dao.getModel());
		return created(Json.toJson(dao.create(t)));
	}

	@Transactional
	public Result update() {
		T t = Json.fromJson(request().body().asJson(), dao.getModel());
	    return ok(Json.toJson(dao.update(t)));
	}
	
	@Transactional
	public Result delete(PK id) {
		dao.delete(id);
		return noContent();
	}
}
