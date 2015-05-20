package controllers.ar.element;

import java.util.List;

import javax.persistence.TypedQuery;

import models.ar.element.ModelElementLink;
import models.ar.element.ModelElementLink.ModelElementLinkType;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and
 * manipulate {@link ModelElementLink} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class ModelElementController extends AbstractCRUDController<ModelElementLink, Long> {
	
	private String elementquerystring = "SELECT a from " + dao.getModel().getSimpleName() + " a where a.type = :type order by a.name";
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is
	 * "@Named("ModelElementLinkDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public ModelElementController(@Named("ModelElementLinkDAO") GenericDAO<ModelElementLink, Long> dao) {
		super(dao);
	}
	
	
	/**
	 * Returns all values of the Enum {@link models.ar.element.ModelElementLink.ModelElementLinkType} as a JsonNode.
	 * 
	 * @return
	 */
	public Result getModelElementLinkType() {
		return ok(Json.toJson(ModelElementLinkType.values()));
	}
	
	
	/**
	 * Provides all {@link ModelElementLinkType.QASElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getQASElements() {
		return getModelElements(ModelElementLinkType.QASElementLink);
	}
	
	/**
	 * Provides all {@link ModelElementLinkType.ComponentElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getComponentElements() {
		return getModelElements(ModelElementLinkType.ComponentElementLink);
	}
	
	/**
	 * Provides all {@link ModelElementLinkType.ContextElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getContextElements() {
		return getModelElements(ModelElementLinkType.ContextElementLink);
	}

	/**
	 * Provides all {@link ModelElementLinkType.DecisionElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getDecisionElements() {
		return getModelElements(ModelElementLinkType.DecisionElementLink);
	}

	/**
	 * Provides all {@link ModelElementLinkType.DesignElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getDesignElements() {
		return getModelElements(ModelElementLinkType.DesignElementLink);
	}
		
	/**
	 * Provides all {@link ModelElementLinkType.ReferenceElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getReferenceElements() {
		return getModelElements(ModelElementLinkType.ReferenceElementLink);
	}
		
	/**
	 * Get all {@link ModelElementLink} for the provided {@link ModelElementLinkType}.
	 * 
	 * @param type
	 * @return
	 */
	@Transactional(readOnly=true)
	public Result getModelElements(ModelElementLinkType type) {
	
		List<ModelElementLink> data;
		try {
			TypedQuery<ModelElementLink> query = JPA.em().createQuery(elementquerystring, ModelElementLink.class);
			query.setParameter("type", type);
			data = dao.find(query);
		} catch (Exception e) {
			String msg = "Failed to get All active " + dao.getModel().getSimpleName();
			Logger.error(msg, e);
			return internalServerError(msg);
		}
		return ok(Json.toJson(data));
	}
}
