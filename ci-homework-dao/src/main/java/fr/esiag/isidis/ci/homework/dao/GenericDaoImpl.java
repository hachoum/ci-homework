package fr.esiag.isidis.ci.homework.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;


import net.jodah.typetools.TypeResolver;

public class GenericDaoImpl<E> implements GenericDao<E>{

	@Inject
    protected EntityManager entityManager;
	private Class<E> entityClass;
	
	public void persist(E e) throws PersistenceException {
		entityManager.persist(e);
	}

	public void merge(E e) throws PersistenceException {
		entityManager.merge(e);
	}

	public void remove(Object id) throws Exception {
		entityManager.remove(findById(id));
	}

	public E findById(Object id) throws Exception {
		return (E) entityManager.find(getEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() throws Exception {
		return entityManager.createQuery(
				"Select t from " + getEntityClass().getSimpleName() + " t")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() throws Exception {
		Class<?>[] typeArguments = TypeResolver.resolveRawArguments(GenericDaoImpl.class, getClass());
		if(typeArguments.length == 1){
			return (Class<E>) typeArguments[0];
		}else{
			throw new Exception("type générique non trouvé");
		}
		
		
	}
	
}
