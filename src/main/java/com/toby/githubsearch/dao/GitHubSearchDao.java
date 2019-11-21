package com.toby.githubsearch.dao;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.toby.githubsearch.domain.DataMap;
import com.toby.githubsearch.domain.SearchData;
import com.toby.githubsearch.domain.SearchResult;

@Repository
public class GitHubSearchDao implements SearchDao {

	private static final String ITEMS = "items";
	private static final String TOTAL_COUNT = "total_count";
	private static final String DESCRIPTION = "description";
	private static final String HTML_URL = "html_url";

	@Override
	public SearchResult get(String text, int pageNo, int pageLimit) {

		long starttime = System.currentTimeMillis();

		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://api.github.com/search/code?q=" + text + "+user:mozilla&page=" + pageNo
				+ "&per_page=" + pageLimit;
		ResponseEntity<DataMap> response = restTemplate.getForEntity(fooResourceUrl, DataMap.class);

		long searchtime = System.currentTimeMillis() - starttime;

		return process(response.getBody(), pageNo, searchtime);
	}

	private SearchResult process(DataMap map, int pageNo, long searchtime) {

		SearchResult result = new SearchResult();
		result.setPageId(pageNo);
		result.setSearchTimeMills(searchtime);
		if (map == null) {
			return result;
		}

		if (map.containsKey(TOTAL_COUNT)) {
			int totalCount = (int) map.get(TOTAL_COUNT);
			result.setTotalCount(totalCount);
		}

		if (map.containsKey(ITEMS)) {
			Object obj = map.get(ITEMS);
			if (obj != null && obj instanceof List<?>) {
				List<Object> objList = (List<Object>) obj;
				if (!objList.isEmpty()) {
					objList.forEach(o -> {
						if (o != null && o instanceof Map<?, ?>) {
							SearchData data = new SearchData();
							Map<String, Object> m = (Map<String, Object>) o;
							String link = (String) m.get(HTML_URL);
							String desc = (String) m.get(DESCRIPTION);
							data.setLink(link);
							data.setDescription(desc);
							result.getData().add(data);
						}
					});
				}
			}
		}
		return result;
	}

}
