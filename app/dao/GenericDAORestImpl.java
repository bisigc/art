package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import play.Logger;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSAuthScheme;
import play.libs.ws.WSResponse;
import utils.restconfig.RestServiceConfig;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;

/**
 * Concrete implementation of a {@link GenericDAO}. The model is still generic
 * and can be concretised with dependency injection. Is annotated with
 * {@link com.google.inject.Singleton}, which makes sure the DI framework
 * creates only one instance of the class.
 * 
 * @author cbi
 *
 * @param <T>
 * @param <PK>
 */
@Singleton
public class GenericDAORestImpl<T, PK extends Serializable> implements
		GenericDAO<T, PK> {

	private Class<T> model;
	private RestServiceConfig config;

	/**
	 * Construction receives a TypeLiteral of the data model to be used.
	 * 
	 * @param model
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
	public List<T> getAll() {
		Promise<JsonNode> jsonPromise = WS
				.url(config.getUrl())
				.setAuth(config.getUser(), config.getPassword(), WSAuthScheme.BASIC)
				.setQueryParameter("basicAuth", "true")
				.setTimeout(config.getTimeout()).get()
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
	public List<T> find(TypedQuery<T> query) {
		return null;
	}

	@Override
	public T create(T t) {
		JsonNode node = Json.toJson(t);
		Promise<JsonNode> jsonPromise = WS
				.url(config.getUrl())
				.setContentType("application/json")
				.setAuth(config.getUser(), config.getPassword(),
						WSAuthScheme.BASIC)
				.setQueryParameter("basicAuth", "true")
				.setTimeout(config.getTimeout()).post(node)
				.map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		node = jsonPromise.get(config.getTimeout());
		return Json.fromJson(node, model);
	}

	@Override
	public T get(PK id) {
		Logger.error("+++++++ " + config.getUrl());
		Promise<JsonNode> jsonPromise = WS
				.url(config.getUrl() + "/" + id.toString())
				.setAuth(config.getUser(), config.getPassword(),
						WSAuthScheme.BASIC)
				.setQueryParameter("basicAuth", "true")
				.setTimeout(config.getTimeout()).get()
				.map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		JsonNode node = jsonPromise.get(config.getTimeout());
		return Json.fromJson(node, model);
	}

	@Override
	public T update(T t) {
		JsonNode node = Json.toJson(t);
		Promise<JsonNode> jsonPromise = WS
				.url(config.getUrl())
				.setContentType("application/json")
				.setAuth(config.getUser(), config.getPassword(),
						WSAuthScheme.BASIC).setTimeout(config.getTimeout())
				.setQueryParameter("basicAuth", "true")
				.put(node).map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		node = jsonPromise.get(config.getTimeout());
		return Json.fromJson(node, model);
	}

	@Override
	public void delete(PK id) {
		WS.url(config.getUrl())
				.setQueryParameter("id", id.toString())
				.setAuth(config.getUser(), config.getPassword(),
						WSAuthScheme.BASIC).setTimeout(config.getTimeout())
				.setQueryParameter("basicAuth", "true")
				.delete().map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
	}
}
