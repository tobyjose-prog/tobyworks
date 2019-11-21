package com.toby.githubsearch.rs;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class SearchSecurityFilter implements javax.ws.rs.container.ContainerRequestFilter {

	private static final String BEARER = "Bearer ";
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED).build();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// Get request headers
		final MultivaluedMap<String, String> headers = requestContext.getHeaders();

		// Fetch authorization header
		final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

		// If no authorization information present; block access
		if (authorization == null || authorization.isEmpty()) {
			requestContext.abortWith(ACCESS_DENIED);
			return;
		}

		Optional<String> token = authorization.stream().filter(t -> t != null && t.startsWith(BEARER)).findFirst();
		if (token.isPresent()) {
			// validate

		} else {
			requestContext.abortWith(ACCESS_DENIED);
			return;
		}

	}

}
