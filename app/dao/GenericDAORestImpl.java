package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import models.AbstractModel;
import play.Logger;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.Json;
import play.libs.ws.WSAuthScheme;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import utils.exceptions.ConflictException;
import utils.exceptions.ItemNotFoundException;
import utils.restconfig.RestServiceConfig;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.TypeLiteral;


/**
 * Concrete implementation of a {@link GenericDAO}. The model is still generic
 * and can be concretised with dependency injection. Is annotated with
 * {@link javax.inject.Singleton}, which makes sure the DI framework
 * creates only one instance of the class.
 * 
 * @author cbi
 *
 * @param <T> Generic Data Model Object
 * @param <PK> Generic Primary Key of Data Model Object
 */
public class GenericDAORestImpl<T extends AbstractModel, PK extends Serializable> implements
		GenericDAO<T, PK> {

	@Inject WSClient ws;
	private Class<T> model;
	private RestServiceConfig config;

	/**
	 * Construction receives a TypeLiteral of the data model to be used.
	 * 
	 * @param model Data Object Model Type
	 * @param config RestService access Configuration
	 */
	@SuppressWarnings("unchecked")
	@Inject
	public GenericDAORestImpl(TypeLiteral<T> model, RestServiceConfig config) {
		this.config = config;
		this.model = (Class<T>) model.getRawType();
	}

	@Override
	public Class<T> getModel() {
		return model;
	}

	@Override
	public List<T> getAll() throws Exception {

		Promise<JsonNode> jsonPromise = ws
				.url(config.getUrl())
				.setAuth(config.getUser(), config.getPassword(), WSAuthScheme.BASIC)
				.setQueryParameter("basicAuth", "true")
				.setRequestTimeout(config.getTimeout()).get()
				.map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		JsonNode node = jsonPromise.get(config.getTimeout());
		node = node.findValue("items");

		List<T> objects = new ArrayList<T>();
		for (Iterator<JsonNode> iterator = node.iterator(); iterator.hasNext();) {
			objects.add(Json.fromJson((ObjectNode) iterator.next(), model));
		}

		return objects;
	}

	@Override
	public List<T> find(TypedQuery<T> query) throws Exception {
		return null;
	}

	@Override
	public T create(T t) throws Exception {
		JsonNode node = Json.toJson(t);
		
		Promise<JsonNode> jsonPromise = ws
				.url(config.getUrl())
				.setContentType("application/json")
				.setAuth(config.getUser(), config.getPassword(), WSAuthScheme.BASIC)
				.setQueryParameter("basicAuth", "true")
				.setRequestTimeout(config.getTimeout())
				.post(node).map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		node = jsonPromise.get(config.getTimeout());
		return Json.fromJson(node, model);
	}

	@Override
	public T get(PK id) throws Exception {

		Promise<JsonNode> jsonPromise = ws
				.url(config.getUrl() + "/" + id.toString())
				.setAuth(config.getUser(), config.getPassword(), WSAuthScheme.BASIC)
				.setQueryParameter("basicAuth", "true")
				.setRequestTimeout(config.getTimeout())
				.get().map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		JsonNode node = jsonPromise.get(config.getTimeout());
		return Json.fromJson(node, model);
	}

	@Override
	public T update(T t) throws Exception {
		JsonNode node = Json.toJson(t);
		String url = config.getUrl() + "/" + t.getId();
		Logger.debug("Update url: " + url);
		Promise<JsonNode> jsonPromise = ws
				.url(url)
				.setContentType("application/json")
				.setAuth(config.getUser(), config.getPassword(), WSAuthScheme.BASIC)
				.setQueryParameter("basicAuth", "true")
				.setRequestTimeout(config.getTimeout())
				.post(node).map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						Logger.error("Reply Status: " + response.getStatus());
						JsonNode json = response.asJson();
						return json;
					}
				});
		node = jsonPromise.get(config.getTimeout());
		return Json.fromJson(node, model);
	}

	@Override
	public void delete(PK id) throws Exception {
		String url = config.getUrl() + "/" + id.toString();
		Logger.debug("Delete url: " + url);
		Promise<Integer> jsonPromise = ws.url(url)
				.setAuth(config.getUser(), config.getPassword(),
						WSAuthScheme.BASIC).setRequestTimeout(config.getTimeout())
				.setQueryParameter("basicAuth", "true")
				.delete().map(new Function<WSResponse, Integer>() {
					public Integer apply(WSResponse response) {
						int status = response.getStatus();
						return status;
					}
				});
		int status = jsonPromise.get(config.getTimeout());
		switch(status) {
			case 204:
				return;
			case 404:
				throw new ItemNotFoundException("Could not find " + model + " with id " + id);
			case 409:
				throw new ConflictException("Conflict while trying to delete " + model + " with id " + id);
			default:
				throw new ConflictException("Conflict while trying to delete " + model + " with id " + id);
		}
	}
}
