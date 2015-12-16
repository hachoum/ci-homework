package fr.esiag.isidis.ci.homework.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import javax.ejb.TransactionManagement;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;


@RunWith(MockitoJUnitRunner.class)
@TransactionManagement
public class EntrepriseDaoImplTest extends  DaoTest{

	
	@Spy
	private static EntrepriseDaoImpl entrepriseDaoImpl = new EntrepriseDaoImpl();
	
	@BeforeClass
	public static void initEntityManager(){
		entrepriseDaoImpl.entityManager = em;
	}
	
	@Test
	public void persist_shoudPersist() {
		// given
		Entreprise entreprise = new Entreprise();
		entreprise.setCodeNaf("codeNaf123");
		entreprise.setDateCreation(new Date());
		entreprise.setDenomination("denomination");
		entreprise.setFormeJuridique("formeJuridique");
		entreprise.setSiren(123456);
		// when
		entrepriseDaoImpl.persist(entreprise);
		em.flush();
		Entreprise result = em.find(Entreprise.class, entreprise.getId());
		// then
		assertThat(result.getCodeNaf()).isEqualTo(entreprise.getCodeNaf());
		assertThat(result.getDateCreation()).isEqualTo(entreprise.getDateCreation());
		assertThat(result.getDenomination()).isEqualTo(entreprise.getDenomination());
		assertThat(result.getFormeJuridique()).isEqualTo(entreprise.getFormeJuridique());
		assertThat(result.getSiren()).isEqualTo(entreprise.getSiren());
	}

	@Test
	public void merge_shoudMerge() {
		// given
		Entreprise entreprise = em.find(Entreprise.class, (long)1);
		// when
		entreprise.setSiren(177);
		entrepriseDaoImpl.merge(entreprise);
		Entreprise result = em.find(Entreprise.class, (long)1);
		// then
		assertThat(result.getSiren()).isEqualTo(entreprise.getSiren());
	}

	@Test
	public void remove_shoudRemove() throws Exception {
		// given
		long entreprise_id = 1;
		// when
		entrepriseDaoImpl.remove(entreprise_id);
		// then
		assertThat(em.find(Entreprise.class, entreprise_id)).isNull();
	}

	@Test
	public void findById_shoudFindElement() throws Exception {
		// given
		long entreprise_id = 1;
		// when
		Entreprise result = entrepriseDaoImpl.findById(entreprise_id);
		// then
		assertThat(result.getSiren()).isEqualTo(1234);
		assertThat(result.getCodeNaf()).isEqualTo("naf001");
		
	}
	
	@Test
	public void findAll_shoudFindAllElement() throws Exception {
		// given

		// when
		List<Entreprise> entreprises = entrepriseDaoImpl.findAll();
		// then
		assertThat(entreprises).hasSize(3);
	}
	
	@Test
	public void findEntrepriseByNumeroSiren_shoudFindElement() throws Exception {
		// given
		Integer siren = 1234;
		// when
		Entreprise entreprise = entrepriseDaoImpl.findEntrepriseByNumeroSiren(siren);
		// then
		assertThat(entreprise.getSiren()).isEqualTo(siren);
	}


}
