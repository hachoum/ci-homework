package fr.esiag.isidis.ci.homework.ws.mapping;


import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import fr.esiag.isidis.ci.homework.service.exception.InvalidDataException;



public class InvalidDataExceptionMapper implements ExceptionMapper<InvalidDataException> {

	@Override
	public Response toResponse(InvalidDataException invalidDataException) {
		return Response.status(Response.Status.BAD_REQUEST).entity(new GenericEntity<String>(invalidDataException.getMessage()) {
		}).type(MediaType.APPLICATION_JSON).build();
	}

}
