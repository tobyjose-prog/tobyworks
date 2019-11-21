package com.toby.githubsearch.svc;

import com.toby.githubsearch.domain.SearchResult;

public interface SearchService {
	public SearchResult search(String text, int pageNo, int limit);
}
