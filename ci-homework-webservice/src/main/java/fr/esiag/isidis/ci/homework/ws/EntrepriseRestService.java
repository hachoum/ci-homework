package fr.esiag.isidis.ci.homework.ws;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.esiag.isidis.ci.homework.dao.dao.model.Entreprise;
import fr.esiag.isidis.ci.homework.service.EntrepriseService;
import fr.esiag.isidis.ci.homework.service.exception.InvalidDataException;
import fr.esiag.isidis.ci.homework.ws.mapping.EntrepriseConverter;



@Path("/entreprise")
public class EntrepriseRestService {

	@Inject
	EntrepriseService entrepriseService;
	
	@Inject
	EntrepriseConverter entrepriseConverter;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findEntrepriseBySiren(@PathParam("numeroSiren") Integer numeroSiren) throws InvalidDataException {
		
		Entreprise entreprise = entrepriseService.existEntrepriseBySiren(numeroSiren);
		
		return Response.ok(entrepriseConverter.reverse().convert(entreprise)).build();
		
	}

}
