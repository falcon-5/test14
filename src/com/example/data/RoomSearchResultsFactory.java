package com.example.data;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

public class RoomSearchResultsFactory extends BaseResponseFactory
{
	private RoomSearchResults mResults = null;
	private Plan mPlan = null;
	private ArrayList<String> mFacilities = null;
	private Stay mStay = null;
	private RoomDate mRoomDate;
	
	@Override
	protected void onStartTag(XmlPullParser parser) throws Exception
	{
		String strTagName = parser.getName();
		int iDepth = parser.getDepth();
		
		if(strTagName.equals("Results"))
		{
			//Resultsタグが見つかったのでインスタンス生成
			mResults = new RoomSearchResults();
		}
		
		if(mResults != null)
		{
			if(strTagName.equals("Plan") && iDepth == 2)
			{
				//Plamタグが見つかったのでインスタンス生成
				mPlan = new Plan();
			}
			else if(strTagName.equals("Facilities"))
			{
				//Facilitiesタグが見つかったので初期化
				if(mFacilities == null)
				{
					mFacilities = new ArrayList<String>();
				}
			}
			else if(strTagName.equals("Stay") && iDepth == 3)
			{
				//Stayタグが見つかったのでインスタンス生成
				mStay = new Stay();
				
				if(mPlan.getStay() == null)
				{
					mPlan.setStay(new ArrayList<Stay>());
				}
			}
			else if(strTagName.equals("Hotel") && iDepth == 3)
			{
				//Hotelタグが見つかったのでインスタンス生成
				if(mPlan != null)
				{
					Hotel hotel = new Hotel();
					mPlan.setHotel(hotel);
				}
			}
			else if(strTagName.equals("Date") && iDepth == 4)
			{
				//Dateタグが見つかったのでインスタンス生成
				if(mStay.getRoomDate() == null)
				{
					mStay.setRoomDate(new ArrayList<RoomDate>());
				}
				mRoomDate = new RoomDate();
				
				//date,month,yearは属性
				mRoomDate.setDate(convertInt(getAttribute(parser, "date")));
				mRoomDate.setMonth(convertInt(getAttribute(parser, "month")));
				mRoomDate.setYear(convertInt(getAttribute(parser, "year")));
			}
			else if(strTagName.equals("Area") && iDepth == 4)
			{
				//Areaタグが見つかったのでインスタンス生成
				mPlan.getHotel().setAera(new Area());
			}
		}
		else
		{
			//フォーマットがおかしい
			throw new Exception("Format Error!");
		}
	}
	
	

}
