package com.example.data;

import java.util.ArrayList;

public class Region extends BaseAreaData
{
	private ArrayList<BaseAreaData> prefecture;

	public ArrayList<BaseAreaData> getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(ArrayList<BaseAreaData> prefecture) {
		this.prefecture = prefecture;
	}
}
