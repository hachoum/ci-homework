package fr.esiag.isidis.ci.homework.ws.mapping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;
import fr.esiag.isidis.ci.homework.ws.model.EntrepriseRest;
import fr.xebia.extras.selma.Selma;

@RunWith(MockitoJUnitRunner.class)
public class EntrepriseMapperTest {

	@Mock
	private Entreprise entreprise;

	@Before
	public void setup(){

		when(entreprise.getId()).thenReturn((long)1);
		when(entreprise.getCodeNaf()).thenReturn("codeNaf");
		when(entreprise.getDateCreation()).thenReturn(new Date());
		when(entreprise.getDateMiseAjour()).thenReturn(new Date());
		when(entreprise.getDenomination()).thenReturn("denomination");
		when(entreprise.getFormeJuridique()).thenReturn("formeJuridique");
		when(entreprise.getSiren()).thenReturn(122);

	}

	@Test
	public void mapInterlocuteurBcpToInterlocuteur_ShouldReturnInterlocuteurMapped() {
		// when
		EntrepriseMapper mapper = Selma.getMapper(EntrepriseMapper.class);

		EntrepriseRest entrepriseRest = mapper.asEntrepriseRest(entreprise);

		// then
		assertThat(entrepriseRest.getCodeActivite()).isEqualTo(entreprise.getCodeNaf());
		assertThat(entrepriseRest.getDateCreation()).isEqualTo(entreprise.getDateCreation());
		assertThat(entrepriseRest.getDateMiseAjour()).isEqualTo(entreprise.getDateMiseAjour());
		assertThat(entrepriseRest.getDenomination()).isEqualTo(entreprise.getDenomination());
		assertThat(entrepriseRest.getFormeJuridique()).isEqualTo(entreprise.getFormeJuridique());
		assertThat(entrepriseRest.getNumeroSiren()).isEqualTo(entreprise.getSiren());
		

	}

}
