package com.example.data;

import java.util.ArrayList;

public class Stay
{
	private String planDetailUrl;		//プラン詳細ページ
	private ArrayList<RoomDate> roomDate;

	public String getPlanDetailUrl()
	{
		return planDetailUrl;
	}
	public void setPlanDetailUrl(String planDetailUrl)
	{
		this.planDetailUrl = planDetailUrl;
	}
	
	public ArrayList<RoomDate> getRoomDate()
	{
		return roomDate;
	}
	public void setRoomDate(ArrayList<RoomDate> roomDate)
	{
		this.roomDate = roomDate;
	}
}
