package com.example.data;

import java.util.ArrayList;

public class LargeArea extends BaseAreaData
{
	private ArrayList<BaseAreaData> smallArea;

	public ArrayList<BaseAreaData> getSmallArea() {
		return smallArea;
	}

	public void setSmallArea(ArrayList<BaseAreaData> smallArea) {
		this.smallArea = smallArea;
	}
}
