package fr.esiag.isidis.ci.homework.dao.producer;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DataProducer {
	@Produces
	@PersistenceContext(unitName = "alternative-test-pu")
	private EntityManager entityManagerTest;

	@Produces
	@Alternative
	@DevDatabase
	@PersistenceContext(unitName = "alternative-dev-pu")
	private EntityManager entityManagerDev;

	@Produces
	@Alternative
	@ProdDatabase
	@PersistenceContext(unitName = "alternative-prod-pu")
	private EntityManager entityManagerProd;	
}
