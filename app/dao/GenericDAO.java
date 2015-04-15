package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

public interface GenericDAO<T, PK extends Serializable> {

	Class<T> getModel();
	List<T> getAll();
	List<T> find(TypedQuery<T> query);
	T create(T t);
	T get(PK id);
	T update(T t);
	void delete(PK id);
}
