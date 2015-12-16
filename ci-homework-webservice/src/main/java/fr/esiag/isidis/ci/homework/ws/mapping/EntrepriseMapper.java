package fr.esiag.isidis.ci.homework.ws.mapping;

import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;
import fr.esiag.isidis.ci.homework.ws.model.EntrepriseRest;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL,
		withCustomFields = { @Field({ "siren", "numeroSiren" }), @Field({ "codeNaf", "codeActivite" })})
public interface EntrepriseMapper {

	EntrepriseRest asEntrepriseRest(Entreprise entreprise);

	@Maps(withCustomFields = { @Field({ "email", "emailLong" }) })
	Entreprise asEntrepriseEntity(EntrepriseRest entrepriseRest);

}
