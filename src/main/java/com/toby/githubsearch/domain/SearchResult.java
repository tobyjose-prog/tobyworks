package com.toby.githubsearch.domain;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

	private int pageId;
	private int totalCount;
	private long searchTimeMills;

	private List<SearchData> data = new ArrayList<SearchData>();

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<SearchData> getData() {
		return data;
	}

	public void setData(List<SearchData> data) {
		this.data = data;
	}

	public long getSearchTimeMills() {
		return searchTimeMills;
	}

	public void setSearchTimeMills(long searchTimeMills) {
		this.searchTimeMills = searchTimeMills;
	}
	

}
