package fr.esiag.isidis.ci.homework.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import fr.esiag.isidis.ci.homework.dao.EntrepriseDao;
import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;
import fr.esiag.isidis.ci.homework.service.exception.InvalidDataException;
import fr.esiag.isidis.ci.homework.service.util.EntrepriseUtil;


@RunWith(PowerMockRunner.class)
@PrepareForTest(EntrepriseUtil.class)
public class EntrepriseServiceTest {

	@Mock
	EntrepriseDao entrepriseDao;

	@InjectMocks
	EntrepriseService entrepriseService = new EntrepriseServiceImpl();

	@Before
	public void setUp() throws Exception {
		mockStatic(EntrepriseUtil.class);
	}

	@Test(expected = InvalidDataException.class)
	public void existEntrepriseBySiren_shouldThrowInvalidDataException()
			throws InvalidDataException {
		// given
		Integer siren = 1;
		when(EntrepriseUtil.isValidSiren(siren)).thenReturn(false);
		// when
		entrepriseService.existEntrepriseBySiren(siren);

		// then
	}

	@Test
	public void existEntrepriseBySiren_shouldThrowRetuenTrue()
			throws InvalidDataException {
		// given
		Integer siren = 1;
		Entreprise entreprise = mock(Entreprise.class);
		when(EntrepriseUtil.isValidSiren(siren)).thenReturn(true);
		when(entrepriseDao.findEntrepriseByNumeroSiren(siren)).thenReturn(entreprise);
		// when
		Entreprise result = entrepriseService.existEntrepriseBySiren(siren);
		// then
		assertThat(entreprise).isEqualTo(result);
	}

}
