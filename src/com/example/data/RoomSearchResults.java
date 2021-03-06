package com.example.data;

import java.util.ArrayList;

public class RoomSearchResults extends BaseData
{
	private int numberOfResults;	//該当件数
	private int displayPerPage;		//表示件数
	private int displayFrom;		//表示From
	private String apiVersion;		//APIバージョン
//	private Plan plan;
	private ArrayList<Plan> plan;

	public int getNumberOfResults()
	{
		return numberOfResults;
	}

	public void setNumberOfResults(int numberOfResults)
	{
		this.numberOfResults = numberOfResults;
	}

	public int getDisplayPerPage()
	{
		return displayPerPage;
	}

	public void setDisplayPerPage(int displayPerPage)
	{
		this.displayPerPage = displayPerPage;
	}

	public int getDisplayFrom()
	{
		return displayFrom;
	}

	public void setDisplayFrom(int displayFrom)
	{
		this.displayFrom = displayFrom;
	}

	public String getApiVersion()
	{
		return apiVersion;
	}

	public void setApiVersion(String apiVersion)
	{
		this.apiVersion = apiVersion;
	}

	public ArrayList<Plan> getPlan() {
		return plan;
	}

	public void setPlan(ArrayList<Plan> plan) {
		this.plan = plan;
	}

}
