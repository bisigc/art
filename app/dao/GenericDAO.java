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
 * @param <T>
 * @param <PK>
 */
public interface GenericDAO<T extends AbstractModel, PK extends Serializable> {

	/**
	 * Returns the class of the data model used in the {@link GenericDAO}.
	 * 
	 * @return
	 */
	Class<T> getModel();
	
	/**
	 * Returns all Objects of the data model.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<T> getAll() throws Exception;
	
	/**
	 * Finds all objects of the data model matching the submitted {@link TypedQuery}.
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<T> find(TypedQuery<T> query) throws Exception;
	
	/**
	 * Receives a data model, persists it and returns the persistet object. 
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	T create(T t) throws Exception;
	
	/**
	 * Returns a data model object which has been retrieved with the
	 * provided primary key.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	T get(PK id) throws Exception;
	
	/**
	 * Receives a data model, persists the changes and returns the persisted object.
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	T update(T t) throws Exception;
	
	/**
	 * Receives the primary key of a data model and deletes it.
	 * 
	 * @param id
	 * @throws Exception
	 */
	void delete(PK id) throws Exception;
}
