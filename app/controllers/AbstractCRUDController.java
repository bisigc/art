package controllers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import models.AbstractModel;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.actions.SessionAuth;
import utils.exceptions.ItemNotFoundException;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Singleton;

import dao.GenericDAO;

/**
 * Abstract class represents a CRUD Controller with the most necessary methods.
 * Create, update, get (read), get all (read all) and a generic query method find.
 * The class contains a {@link GenericDAO} with the parameters T (Model Class) and PK (Private Key).
 * Class is annotated with {@link com.google.inject.Singleton} which advises the DI framework
 * to instantiate the class only once. 
 * 
 * @author cbi
 *
 * @param <T>
 * @param <PK>
 */
@Singleton
public abstract class AbstractCRUDController<T extends AbstractModel, PK extends Serializable> extends Controller {
	
	/**
	 * Gerneric DAO
	 */
	protected GenericDAO<T, PK> dao;
	
	/**
	 * Constructor receives a {@link GenericDAO} object. Which can be dependency injected.
	 * @param dao
	 */
	public AbstractCRUDController(GenericDAO<T, PK> dao) {
		this.dao = dao;
	}
	
	/**
	 * Find Method returns a list of model objects from the {@link GenericDAO}, depending on the given query.
	 * 
	 * @param query
	 * @return
	 */
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
	
	/**
	 * getAll returns a list of all model objects from the {@link GenericDAO}.
	 * @return
	 */
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
	
	/**
	 * Returns the model object delivered by the {@link GenericDAO}, corresponding to the given primary key object. 
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public Result get(PK id) {
		T t;
		try {
			t = dao.get(id);
		} catch (ItemNotFoundException e) {
			Logger.error(e.getMessage(), e);
			return notFound(e.getMessage());
		} catch (Exception e) {
			String msg = "Failed to get " + dao.getModel().getSimpleName() + " with id " + id;
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return t == null ? notFound() : ok(Json.toJson(t));
	}
	
	/**
	 * Creates a model object via the {@link GenericDAO}, given by the serialized Object of
	 * the delivered JSON Node from the HTTP request.
	 * Method is annotated with {@link SessionAuth} action, which intercepts the request, to
	 * verify the callers session and permissions.
	 * 
	 * @return
	 */
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

	/**
	 * Updates a model object via the {@link GenericDAO} given by the serialized Object of the delivered JSON Node from the HTTP request. 
	 * Method is annotated with {@link SessionAuth} action, which intercepts the request, to
	 * verify the callers session and permissions.
	 * 
	 * @return
	 */
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
	
	/**
	 * Deletes a model object via the {@link GenericDAO}, given by the delivered primary key object.
	 * Method is annotated with {@link SessionAuth} action, which intercepts the request, to
	 * verify the callers session and permissions.
	 * 
	 * @param id
	 * @return
	 */
	@SessionAuth
	@Transactional
	public Result delete(PK id) {
		try {
			dao.delete(id);
		} catch (ItemNotFoundException e) {
			Logger.error(e.getMessage(), e);
			return notFound(e.getMessage());
		} catch (Exception e) {
			String msg = "Failed to delete " + dao.getModel().getSimpleName() + " with id " + id;
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return noContent();
	}
}
