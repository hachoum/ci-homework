package fr.esiag.isidis.ci.homework.dao;

import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;


public class EntrepriseDaoImpl extends GenericDaoImpl<Entreprise> implements EntrepriseDao {

	public Entreprise findEntrepriseByNumeroSiren(Integer siren) {
		return (Entreprise) entityManager.createNamedQuery("entreprise.findEntrepriseBySiren",Entreprise.class)
		.setParameter("siren",siren)
		.getSingleResult();
	}

}
