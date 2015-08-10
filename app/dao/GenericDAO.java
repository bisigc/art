package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import models.AbstractModel;

/**
 * Interface for a {@link GenericDAO}.
 * 
 * @author cbi
 *
 * @param <T> Generic Data Model Object
 * @param <PK> Generic Primary Key of Data Model Object
 */
public interface GenericDAO<T extends AbstractModel, PK extends Serializable> {

	/**
	 * Returns the class of the data model used in the {@link GenericDAO}.
	 * 
	 * @return Class of the injected Model
	 */
	Class<T> getModel();
	
	/**
	 * Returns all Objects of the data model.
	 * 
	 * @return List of all objects of the data model
	 * @throws Exception if data access failed
	 */
	List<T> getAll() throws Exception;
	
	/**
	 * Finds all objects of the data model matching the submitted {@link TypedQuery}.
	 * 
	 * @param query Typed Query
	 * @return List of all found data objects
	 * @throws Exception if data access failed
	 */
	List<T> find(TypedQuery<T> query) throws Exception;
	
	/**
	 * Receives a data model, persists it and returns the persistet object. 
	 * 
	 * @param t model object
	 * @return created model object
	 * @throws Exception if data source access failed
	 */
	T create(T t) throws Exception;
	
	/**
	 * Returns a data model object which has been retrieved with the
	 * provided primary key.
	 * 
	 * @param id primary key
	 * @return data object
	 * @throws Exception if data access failed
	 */
	T get(PK id) throws Exception;
	
	/**
	 * Receives a data model, persists the changes and returns the persisted object.
	 * 
	 * @param t data object
	 * @return updated data object
	 * @throws Exception if data source access failed
	 */
	T update(T t) throws Exception;
	
	/**
	 * Receives the primary key of a data model and deletes it.
	 * 
	 * @param id primary key
	 * @throws Exception if data source access failed
	 */
	void delete(PK id) throws Exception;
}
