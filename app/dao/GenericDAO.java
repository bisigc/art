package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

public interface GenericDAO<T, PK extends Serializable> {

	Class<T> getModel();
	List<T> getAll() throws Exception;
	List<T> find(TypedQuery<T> query) throws Exception;
	T create(T t) throws Exception;
	T get(PK id) throws Exception;
	T update(T t) throws Exception;
	void delete(PK id) throws Exception;
}
