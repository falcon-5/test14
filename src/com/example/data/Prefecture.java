package com.example.data;

import java.util.ArrayList;

public class Prefecture extends BaseAreaData
{
	private ArrayList<BaseAreaData> largeData;

	public ArrayList<BaseAreaData> getLargeData() {
		return largeData;
	}

	public void setLargeData(ArrayList<BaseAreaData> largeData) {
		this.largeData = largeData;
	}
}
