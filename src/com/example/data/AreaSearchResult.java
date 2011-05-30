package com.example.data;

public class AreaSearchResult extends BaseData
{
	private String apiVersion;
	private SearchArea area;
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public SearchArea getArea() {
		return area;
	}
	public void setArea(SearchArea area) {
		this.area = area;
	}
}
