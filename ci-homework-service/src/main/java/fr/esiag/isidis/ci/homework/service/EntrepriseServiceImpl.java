package fr.esiag.isidis.ci.homework.service;



import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;

import fr.esiag.isidis.ci.homework.dao.EntrepriseDao;
import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;
import fr.esiag.isidis.ci.homework.service.exception.InvalidDataException;
import fr.esiag.isidis.ci.homework.service.util.EntrepriseUtil;


@Stateless
@TransactionManagement
public class EntrepriseServiceImpl  implements EntrepriseService{

	
	@Inject
	private EntrepriseDao entrepriseDao;
	
	public Entreprise existEntrepriseBySiren(Integer siren) throws InvalidDataException{
		
		if(EntrepriseUtil.isValidSiren(siren)){
			return entrepriseDao.findEntrepriseByNumeroSiren(siren);
		}else{
			throw new InvalidDataException("Numéro siren non valide");
		}
		
	}
	
}

