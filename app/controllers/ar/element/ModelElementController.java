package controllers.ar.element;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;

import models.ar.element.ModelElementLink;
import models.ar.element.ModelElementLink.ModelElementLinkType;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
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
	 * @param dao GenericDAO
	 */
	@Inject
	public ModelElementController(@Named("ModelElementLinkDAO") GenericDAO<ModelElementLink, Long> dao) {
		super(dao);
	}
	
	
	/**
	 * Returns all values of the Enum {@link models.ar.element.ModelElementLink.ModelElementLinkType} as a JsonNode.
	 * 
	 * @return HTTP result
	 */
	public Result getModelElementLinkType() {
		return ok(Json.toJson(ModelElementLinkType.values()));
	}
	
	
	/**
	 * Provides all {@link models.ar.element.ModelElementLink.ModelElementLinkType#QASElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getQASElements() {
		return getModelElements(ModelElementLinkType.QASElementLink);
	}
	
	/**
	 * Provides all {@link models.ar.element.ModelElementLink.ModelElementLinkType#ComponentElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getComponentElements() {
		return getModelElements(ModelElementLinkType.ComponentElementLink);
	}
	
	/**
	 * Provides all {@link models.ar.element.ModelElementLink.ModelElementLinkType#ContextElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getContextElements() {
		return getModelElements(ModelElementLinkType.ContextElementLink);
	}

	/**
	 * Provides all {@link models.ar.element.ModelElementLink.ModelElementLinkType#DecisionElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getDecisionElements() {
		return getModelElements(ModelElementLinkType.DecisionElementLink);
	}

	/**
	 * Provides all {@link models.ar.element.ModelElementLink.ModelElementLinkType#DesignElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getDesignElements() {
		return getModelElements(ModelElementLinkType.DesignElementLink);
	}
		
	/**
	 * Provides all {@link models.ar.element.ModelElementLink.ModelElementLinkType#ReferenceElementLink}.
	 * 
	 * @return HTTP result
	 */
	@Transactional(readOnly=true)
	public Result getReferenceElements() {
		return getModelElements(ModelElementLinkType.ReferenceElementLink);
	}
		
	/**
	 * Get all {@link ModelElementLink} for the provided {@link models.ar.element.ModelElementLink.ModelElementLinkType}.
	 * 
	 * @param type of the ModelElementLink
	 * @return HTTP result
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
