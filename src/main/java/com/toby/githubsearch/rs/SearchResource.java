package com.toby.githubsearch.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.toby.githubsearch.dao.SearchDao;
import com.toby.githubsearch.domain.SearchResult;
import com.toby.githubsearch.svc.SearchService;

@Path("/github")
public class SearchResource implements SearchService {

	@Autowired
	private SearchDao searchDao;

	@GET
	@Path("/search")
	@Produces({ MediaType.APPLICATION_JSON })
	public SearchResult search(@QueryParam("text") String text, @QueryParam("pageno") int pageNo,
			@QueryParam("limit") int limit) {
		if (text == null || text.isBlank()) {
			throw new SearchFailureException("Empty Search");
		}
		return searchDao.get(text, pageNo == 0 ? 1 : pageNo, limit == 0 ? 100 : limit);
	}

	@ExceptionHandler(SearchFailureException.class)
	public String error(SearchFailureException exp) {
		return exp.getMessage();

	}

}
