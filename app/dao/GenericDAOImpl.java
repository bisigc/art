package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import play.db.jpa.JPA;

import com.google.inject.Inject;
import com.google.inject.TypeLiteral;

public class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {
	
	private Class<T> model;
	
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
		return JPA.em().createQuery("select a from " + model.getName() + " a", model).getResultList();
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
