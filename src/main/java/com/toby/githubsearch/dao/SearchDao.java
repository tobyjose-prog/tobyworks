package com.toby.githubsearch.dao;

import com.toby.githubsearch.domain.SearchResult;

public interface SearchDao {

	SearchResult get(String text, int pageNo, int pageLimit);
}
