package fr.esiag.isidis.ci.homework.service;

import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;
import fr.esiag.isidis.ci.homework.service.exception.InvalidDataException;

public interface EntrepriseService {

	public Entreprise existEntrepriseBySiren(Integer siren) throws InvalidDataException;
}
