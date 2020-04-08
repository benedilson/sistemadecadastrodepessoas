package br.com.backend.dao.interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface GenericoDAORemote<T, K> {

	List<T> all();

	T byId(K id);

	T insert(T entity);

	T update(T entity);

	void delete(T entity);

	void deleteById(K id);
}
