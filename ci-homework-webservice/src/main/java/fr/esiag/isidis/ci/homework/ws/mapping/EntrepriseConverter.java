package fr.esiag.isidis.ci.homework.ws.mapping;

import javax.inject.Singleton;

import com.google.common.base.Converter;

import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;
import fr.esiag.isidis.ci.homework.ws.model.EntrepriseRest;
import fr.xebia.extras.selma.Selma;


@Singleton
public class EntrepriseConverter extends Converter<EntrepriseRest, Entreprise> {

	private final EntrepriseMapper entrepriseMapper;

	public EntrepriseConverter() {
		entrepriseMapper = Selma.getMapper(EntrepriseMapper.class);
	}

	@Override
	protected EntrepriseRest doBackward(Entreprise entrepriseBcp) {
		return entrepriseMapper.asEntrepriseRest(entrepriseBcp);
	}

	@Override
	protected Entreprise doForward(EntrepriseRest entrepriseRest) {
		return entrepriseMapper.asEntrepriseEntity(entrepriseRest);
	}

}