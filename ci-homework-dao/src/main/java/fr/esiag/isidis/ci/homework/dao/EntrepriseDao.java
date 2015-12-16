package fr.esiag.isidis.ci.homework.dao;

import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;



public interface EntrepriseDao extends GenericDao<Entreprise> {
	
	public Entreprise findEntrepriseByNumeroSiren(Integer siren);
	
	
}
