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

	@Override
	protected void onEndTag(XmlPullParser parser)
	{
		String strTagName = parser.getName();
		int iDepth = parser.getDepth();

		if(strTagName.equals("Plan"))
		{
			//Planタグの終了時にリストに追加
			if(mResults.getPlan() == null)
			{
				mResults.setPlan(new ArrayList<Plan>());
			}
			mResults.getPlan().add(mPlan);
		}
		else if(strTagName.equals("Date") && iDepth == 4)
		{
			//StayクラスにRoomDateクラスのインスタンスをセット
			if(mRoomDate != null)
			{
				mStay.getRoomDate().add(mRoomDate);
			}
		}
		else if(strTagName.equals("Stay") && iDepth == 3)
		{
			//Stayインスタンスをセット
			mPlan.getStay().add(mStay);
		}
		else if(strTagName.equals("Facilities"))
		{
			//Facilitiesをセット
			mPlan.setFacilities(mFacilities);
			mFacilities = null;
		} else if(strTagName.equals("NumberOfResults")) {
			mResults.setNumberOfResults(convertInt(mText));
		} else if(strTagName.equals("DisplayPerPage")) {
			mResults.setDisplayPerPage(convertInt(mText));
		} else if(strTagName.equals("DisplayFrom")) {
			mResults.setDisplayFrom(convertInt(mText));
		} else if(strTagName.equals("APIVersion")) {
			mResults.setApiVersion(mText);
		} else if(strTagName.equals("PlanName")) {
			mPlan.setPlanName(mText);
		} else if(strTagName.equals("RoomName")) {
			mPlan.setRoomName(mText);
		} else if(strTagName.equals("PlanDetailURL")) {
			if(iDepth ==3){
				mPlan.setPlanDetailUrl(mText);
			}else if(iDepth == 4){
				mStay.setPlanDetailUrl(mText);
			}
		} else if(strTagName.equals("PlanCommonDetailURL")) {
			mPlan.setPlanCommonDetailUrl(mText);
		} else if(strTagName.equals("Facility")) {
			if(mText.trim().length() > 0) {
				mFacilities.add(mText);
			}
		} else if(strTagName.equals("PlanCheckIn")) {
			mPlan.setPlanCheckIn(mText);
		} else if(strTagName.equals("PlanCheckOut")) {
			mPlan.setPlanCheckOut(mText);
		} else if(strTagName.equals("PlanPictureURL")) {
			mPlan.setPlanPictureUrl(mText);
		} else if(strTagName.equals("PlanPictureCaption")) {
			mPlan.setPlanPictureCaption(mText);
		} else if(strTagName.equals("Meal")) {
			mPlan.setMeal(mText);
		} else if(strTagName.equals("RateType")) {
			mPlan.setRateType(mText);
		} else if(strTagName.equals("SampleRate")) {
			mPlan.setSampleRate(convertInt(mText));
		} else if(strTagName.equals("Rate")) {
			if(mRoomDate != null) {
				mRoomDate.setRate(convertInt(mText));
			}
		} else if(strTagName.equals("Stock")) {
			if(mRoomDate != null) {
				mRoomDate.setStock(convertInt(mText));
			}
		} else if(strTagName.equals("HotelID")) {
			mPlan.getHotel().setHotelID(convertInt(mText));
		} else if(strTagName.equals("HotelName")) {
			mPlan.getHotel().setHotelName(mText);
		} else if(strTagName.equals("PostCode")) {
			mPlan.getHotel().setPostCode(mText);
		} else if(strTagName.equals("HotelAddress")) {
			mPlan.getHotel().setHotelAddress(mText);
		} else if(strTagName.equals("Region")) {
			mPlan.getHotel().getArea().setRegion(mText);
		} else if(strTagName.equals("Prefecture")) {
			mPlan.getHotel().getArea().setPrefecture(mText);
		} else if(strTagName.equals("LargeArea")) {
			mPlan.getHotel().getArea().setLargeArea(mText);
		} else if(strTagName.equals("SmallArea")) {
			mPlan.getHotel().getArea().setSmallArea(mText);
		} else if(strTagName.equals("HotelType")) {
			mPlan.getHotel().setHotelType(mText);
		} else if(strTagName.equals("HotelDetailURL")) {
			mPlan.getHotel().setHotelDetailUrl(mText);
		} else if(strTagName.equals("HotelCatchCopy")) {
			mPlan.getHotel().setHotelCatchCopy(mText);
		} else if(strTagName.equals("HotelCaption")) {
			mPlan.getHotel().setHotelCaption(mText);
		} else if(strTagName.equals("PictureURL")) {
			mPlan.getHotel().setPictureUrl(mText);
		} else if(strTagName.equals("PictureCaption")) {
			mPlan.getHotel().setPictureCaption(mText);
		} else if(strTagName.equals("X")) {
			mPlan.getHotel().setX(convertLong(mText));
		} else if(strTagName.equals("Y")) {
			mPlan.getHotel().setY(convertLong(mText));
		} else if(strTagName.equals("HotelNameKana")) {
			mPlan.getHotel().setHotelNameKana(mText);
		} else if(strTagName.equals("NumberOfRatings")) {
			mPlan.getHotel().setNumberOfRatings(convertInt(mText));
		} else if(strTagName.equals("Rating")) {
			mPlan.getHotel().setRating(convertDouble(mText));
		}
	}

	@Override
	protected BaseData getResponse(){
		return mResults;
	}

}
