package com.toby.githubsearch.rs;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SearchExpHandler implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		return Response.serverError().entity(exception.getMessage()).build();
	}

}
