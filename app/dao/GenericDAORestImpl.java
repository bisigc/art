package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSAuthScheme;
import play.libs.ws.WSResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	private String url;
	private String user;
	private String password;

	/**
	 * Construction receives a TypeLiteral of the data model to be used.
	 * 
	 * @param model
	 */
	@SuppressWarnings("unchecked")
	@Inject
	public GenericDAORestImpl(TypeLiteral<T> model) {
		this.model = (Class<T>) model.getRawType();
	}

	@Override
	public Class<T> getModel() {
		return model;
	}

	@Override
	public List<T> getAll() {
		Promise<JsonNode> jsonPromise = WS.url(url)
				.setAuth(user, password, WSAuthScheme.BASIC)
				.setTimeout(1000).get()
				.map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		JsonNode node = jsonPromise.get(0);
		ObjectMapper omapper = new ObjectMapper();
		
		List<T> objects;
		try {
			objects = omapper.readValue(node.asText(), omapper.getTypeFactory().constructCollectionType(List.class, model));
		} catch (Exception e) {
			return null;
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
		Promise<JsonNode> jsonPromise = WS.url(url)
				.setContentType("application/json")
				.setAuth(user, password, WSAuthScheme.BASIC)
				.setTimeout(1000).post(node)
				.map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		node = jsonPromise.get(0);
		return Json.fromJson(node, model);
	}

	@Override
	public T get(PK id) {
		Promise<JsonNode> jsonPromise = WS.url(url)
				.setQueryParameter("id", id.toString())
				.setAuth(user, password, WSAuthScheme.BASIC)
				.setTimeout(1000).get()
				.map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		JsonNode node = jsonPromise.get(0);
		return Json.fromJson(node, model);
	}

	@Override
	public T update(T t) {
		JsonNode node = Json.toJson(t);
		Promise<JsonNode> jsonPromise = WS.url(url)
				.setContentType("application/json")
				.setAuth(user, password, WSAuthScheme.BASIC)
				.setTimeout(1000).put(node)
				.map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
		node = jsonPromise.get(0);
		return Json.fromJson(node, model);
	}

	@Override
	public void delete(PK id) {
		WS.url(url)
				.setQueryParameter("id", id.toString())
				.setAuth(user, password, WSAuthScheme.BASIC)
				.setTimeout(1000).delete()
				.map(new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						JsonNode json = response.asJson();
						return json;
					}
				});
	}
}
