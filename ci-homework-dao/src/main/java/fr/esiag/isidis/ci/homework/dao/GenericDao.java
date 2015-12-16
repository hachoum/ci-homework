package fr.esiag.isidis.ci.homework.dao;

import java.util.List;


public interface GenericDao<E> {
	
	void persist(E e) throws Exception;
	
	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;
	
	E findById(Object id) throws Exception;
	
	List<E> findAll() throws Exception;
	
}
