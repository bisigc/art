package controllers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.actions.SessionAuth;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Singleton;

import dao.GenericDAO;

@Singleton
public abstract class AbstractCRUDController<T, PK extends Serializable> extends Controller {
	
	protected GenericDAO<T, PK> dao;
	
	public AbstractCRUDController(GenericDAO<T, PK> dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly=true)
	public Result find(TypedQuery<T> query) {
		List<T> data;
		try {
			data = dao.find(query);
		} catch (Exception e) {
			Logger.error("Failed to find elements, " + query, e);
			return internalServerError("Failed to find elements, " + dao.getModel().getSimpleName());
		}
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public Result getAll() {
		List<T> data;
		try {
			data = dao.getAll();
		} catch (Exception e) {
			String msg = "Failed to get All " + dao.getModel().getSimpleName();
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(data));
	}
	
	@Transactional(readOnly=true)
	public Result get(PK id) {
		T t;
		try {
			t = dao.get(id);
		} catch (Exception e) {
			String msg = "Failed to get " + dao.getModel().getSimpleName() + " with id " + id;
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return t == null ? notFound() : ok(Json.toJson(t));
	}
	
	@SessionAuth
	@Transactional
	public Result create() {
		JsonNode node = request().body().asJson();
		T created;
		try {
			T t = Json.fromJson(node, dao.getModel());
			created = dao.create(t);
		} catch (Exception e) {
			String msg = "Failed to create, " + dao.getModel().getSimpleName();
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
		return created(Json.toJson(created));
	}

	@SessionAuth
	@Transactional
	public Result update() {
		JsonNode node = request().body().asJson();
		T updated;
		try {
			T t = Json.fromJson(node, dao.getModel());
			updated = dao.update(t);
		} catch (Exception e) {
			String msg = "Failed to update, " + dao.getModel().getSimpleName();
			Logger.error(msg + " JSON: " + node, e);
			return internalServerError(msg);
		}
	    return ok(Json.toJson(updated));
	}
	
	@SessionAuth
	@Transactional
	public Result delete(PK id) {
		try {
			dao.delete(id);
		} catch (Exception e) {
			String msg = "Failed to delete " + dao.getModel().getSimpleName() + " with id " + id;
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return noContent();
	}
}
