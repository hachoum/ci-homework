package fr.esiag.isidis.ci.homework.dao;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;



@RunWith(MockitoJUnitRunner.class)
public class GenericDaoImplTest {

	@Mock
	EntityManager entityManager;
	
	@Mock
	Entreprise entreprise;
	
	@Spy
	@InjectMocks
	GenericDaoImpl<Entreprise> genericDao;
		
	
	@Test
	public void persist_shouldCallPersist(){
		//given
		
		//when
		genericDao.persist(entreprise);
		
		//then
		verify(entityManager).persist(entreprise);
	}
	
	@Test
	public void merge_shouldCallMerge(){
		//given
		
		//when
		genericDao.merge(entreprise);
		
		//then
		verify(entityManager).merge(entreprise);
	}
	
	@Test
	public void findById_shouldCallFindById() throws Exception{
		//given
		Integer entrepriseId = 1234;
		
		//when
		doReturn(Entreprise.class).when(genericDao).getEntityClass();
		genericDao.findById(entrepriseId);
		
		//then
		verify(entityManager).find(Entreprise.class, entrepriseId);
	}
	
	@Test
	public void remove_shouldCallRemove() throws Exception{
		//given
		Integer entrepriseId = 1234;
		
		//when
		doReturn(Entreprise.class).when(genericDao).getEntityClass();
		when(genericDao.findById(entrepriseId)).thenReturn(entreprise);
		genericDao.remove(entrepriseId);
		
		//then
		verify(entityManager).remove(entreprise);
		verify(genericDao,times(2)).findById(entrepriseId);
	}
	
	@Test
	public void findAll_shouldCreateRightQuery()throws Exception{
		//given
		String stringQuery = "Select t from Entreprise t";
		Query query = mock(Query.class);
		//when
		doReturn(Entreprise.class).when(genericDao).getEntityClass();
		doReturn(query).when(entityManager).createQuery(stringQuery);
		genericDao.findAll();
		//then
		verify(entityManager).createQuery(stringQuery);
	}
	
	@Test
	public void getEntityClass_souldGetEntityClass() throws Exception{
		//given 
		
		//when
		Class<Entreprise> clazz = genericDao.getEntityClass();
		//then
//		assertThat(clazz).isEqualTo(Class<Entreprise>);
	}
	
	@Test(expected=Exception.class)
	public void getEntityClass_souldThrowException() throws Exception{
		//given 
		String stringClass = mock(String.class, CALLS_REAL_METHODS);
		//when
		genericDao.getEntityClass();
		//then
//		assertThat(clazz).isEqualTo(Entreprise.class);
	}
	
	
	
	
}
