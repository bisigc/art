package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import play.db.jpa.JPA;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;

/**
 * Concrete implementation of a {@link GenericDAO}. The model is still
 * generic and can be concretised with dependency injection.
 * Is annotated with {@link com.google.inject.Singleton}, which makes sure
 * the DI framework creates only one instance of the class.
 * 
 * @author cbi
 *
 * @param <T>
 * @param <PK>
 */
@Singleton
public class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {
	
	private Class<T> model;
	
	/**
	 * Construction receives a TypeLiteral of the data model to be used.
	 * 
	 * @param model
	 */
	@SuppressWarnings("unchecked")
	@Inject
	public GenericDAOImpl(TypeLiteral<T> model) {
		this.model = (Class<T>) model.getRawType();
	}

	@Override
	public Class<T> getModel() {
		return model;
	}
	
	@Override
	public List<T> getAll() {
		TypedQuery<T> query =  JPA.em().createQuery("select a from " + model.getName() + " a", model);
		List<T> list = query.getResultList(); 
		return list;
	}

	@Override
	public List<T> find(TypedQuery<T> query) {
		return query.getResultList();
	}

	@Override
	public T create(T t) {
	    JPA.em().persist(t);
		return t;
	}

	@Override
	public T get(PK id) {
		return JPA.em().find(model, id);
	}

	@Override
	public T update(T t) {
	    JPA.em().merge(t);
		return t;
	}

	@Override
	public void delete(PK id) {
		T t = JPA.em().find(model, id);
		JPA.em().remove(t);
	}
}
