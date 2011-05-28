package com.example.data;

import java.util.ArrayList;

public class Plan
{
	private String planName;				//プラン名
	private String roomName;				//部屋名
	private String planDetailUrl;			//プラン詳細ページ
	private String planCommonDetailUrl;		//（マニュアルに載っていない項目）
	private ArrayList<String> facilities;	//部屋設備
	private String planCheckIn;				//チェックイン
	private String planCheckOut;			//チェックアウト
	private String planPictureUrl;			//プラン画像URL
	private String planPictureCaption;		//プラン画像説明
	private String meal;					//食事条件
	private String rateType;				//料金タイプ
	private int sampleRate;					//参考料金
//	private Stay stay;
	private ArrayList<Stay> stay;
	private Hotel hotel;

	public String getPlanName()
	{
		return planName;
	}

	public void setPlanName(String planName)
	{
		this.planName = planName;
	}

	public String getRoomName()
	{
		return roomName;
	}

	public void setRoomName(String roomName)
	{
		this.roomName = roomName;
	}

	public String getPlanDetailUrl()
	{
		return planDetailUrl;
	}

	public void setPlanDetailUrl(String planDetailUrl)
	{
		this.planName = planDetailUrl;
	}

	public String getPlanCommonDetailUrl()
	{
		return planCommonDetailUrl;
	}

	public void setPlanCommonDetailUrl(String planCommonDetailUrl)
	{
		this.planCommonDetailUrl = planCommonDetailUrl;
	}

	public ArrayList<String> getFacilities()
	{
		return facilities;
	}

	public void setFacilities(ArrayList<String> facilities)
	{
		this.facilities = facilities;
	}

	public String getPlanCheckIn()
	{
		return planCheckIn;
	}

	public void setPlanCheckIn(String planCheckIn)
	{
		this.planCheckIn = planCheckIn;
	}

	public String getPlanCheckOut()
	{
		return planCheckOut;
	}

	public void setPlanCheckOut(String planCheckOut)
	{
		this.planCheckOut = planCheckOut;
	}

	public String getPlanPictureUrl()
	{
		return planPictureUrl;
	}

	public void setPlanPictureUrl(String planPictureUrl)
	{
		this.planPictureUrl = planPictureUrl;
	}

	public String getPlanPictureCaption()
	{
		return planPictureCaption;
	}

	public void setPlanPictureCaption(String planPictureCaption)
	{
		this.planPictureCaption = planPictureCaption;
	}

	public String getMeal()
	{
		return meal;
	}

	public void setMeal(String meal)
	{
		this.meal = meal;
	}

	public String getRateType()
	{
		return rateType;
	}

	public void setRateType(String rateType)
	{
		this.rateType = rateType;
	}

	public int getSampleRate()
	{
		return sampleRate;
	}

	public void setSampleRate(int sampleRate)
	{
		this.sampleRate = sampleRate;
	}

	public ArrayList<Stay> getStay() {
		return stay;
	}

	public void setStay(ArrayList<Stay> stay) {
		this.stay = stay;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
