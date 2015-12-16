package fr.esiag.isidis.ci.homework.service.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class EntrepriseUtilTest {
	
	
	@InjectMocks
	EntrepriseUtil entrepriseUtil;
	
	@SuppressWarnings("static-access")
	@Test
	public void isValidSiren_shouldReturnTrue(){
		//given
		//siren de la poste
		Integer siren = 356000000;
		//when
		boolean result = entrepriseUtil.isValidSiren(siren);
		//then
		assertThat(result).isEqualTo(true);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isValidSiren_shouldReturnFalse(){
		//given
		Integer siren = 1;
		//when
		boolean result = entrepriseUtil.isValidSiren(siren);
		//then
		assertThat(result).isEqualTo(false);
	}

}
