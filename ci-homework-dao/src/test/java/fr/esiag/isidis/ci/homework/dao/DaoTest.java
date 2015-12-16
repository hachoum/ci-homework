package fr.esiag.isidis.ci.homework.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class DaoTest {
	protected static EntityManagerFactory emf;
	protected static EntityManager em ;
	
	@BeforeClass
	public static void setup(){
		emf = Persistence.createEntityManagerFactory("alternative-test-pu");
		em = emf.createEntityManager();
	}
	
	@AfterClass
	public static void clean(){
		em.close();
		emf.close();
		
	}
	
	
	@Before
	public void beginTransaction(){
		if(!em.getTransaction().isActive()){
			em.getTransaction().begin();
		}
	}

	
	@After
	public void rollbackTransaction(){
		if(em.getTransaction().isActive()){
			em.getTransaction().rollback();
		}
	}
	
}
