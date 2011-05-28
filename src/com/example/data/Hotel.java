package com.example.data;

public class Hotel {
	private int hotelID;			//宿番号
	private String hotelName;		//宿名漢字
	private String postCode;		//郵便番号
	private String hotelAddress;	//住所
	private Area area;				//地域
	private String hotelType;		//宿種名
	private String hotelDetailUrl;	//宿詳細ページURL
	private String hotelCatchCopy;	//キャッチ
	private String hotelCaption;	//コピー
	private String pictureUrl;		//宿画像URL
	private String pictureCaption;	//宿画像キャプション
	private long x;					//経度（ミリ秒）
	private long y;					//緯度（ミリ秒）
	private String hotelNameKana;	//宿名かな
	private int numberOfRatings;	//口コミ件数
	private double rating;			//口コミ評価（マニュアルには「半角数字」とあるが小数が送られる）
	
	public int getHotelID()
	{
		return hotelID;
	}
	
	public void setHotelID(int hotelID)
	{
		this.hotelID = hotelID;
	}
	
	public String getHotelName()
	{
		return hotelName;
	}
	
	public void setHotelName(String hotelName)
	{
		this.hotelName = hotelName;
	}
	
	public String getPostCode()
	{
		return postCode;
	}
	
	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}
	
	public String getHotelAddress()
	{
		return hotelAddress;
	}
	
	public void setHotelAddress(String hotelAddress)
	{
		this.hotelAddress = hotelAddress;
	}
	
	public Area getArea()
	{
		return area;
	}
	
	public void setAera(Area area)
	{
		this.area = area;
	}
	
	public String getHotelType()
	{
		return hotelType;
	}
	
	public void setHotelType(String hotelType)
	{
		this.hotelType = hotelType;
	}
	
	public String getHotelDetailUrl()
	{
		return hotelDetailUrl;
	}
	
	public void setHotelDetailUrl(String hotelDetailUrl)
	{
		this.hotelDetailUrl = hotelDetailUrl;
	}
	
	public String getHotelCatchCopy()
	{
		return hotelCatchCopy;
	}
	
	public void setHotelCatchCopy(String hotelCatchCopy)
	{
		this.hotelCatchCopy = hotelCatchCopy;
	}
	
	public String getHotelCaption()
	{
		return hotelCaption;
	}
	
	public void setHotelCaption(String hotelCaption)
	{
		this.hotelCaption = hotelCaption;
	}
	
	public String getPictureUrl()
	{
		return pictureUrl;
	}
	
	public void setPictureUrl(String pictureUrl)
	{
		this.pictureUrl = pictureUrl;
	}
	
	public String getPictureCaption()
	{
		return pictureCaption;
	}
	
	public void setPictureCaption(String pictureCaption)
	{
		this.pictureCaption = pictureCaption;
	}
	
	public long getX()
	{
		return x;
	}
	
	public void setX(long x)
	{
		this.x = x;
	}
	
	public long getY()
	{
		return y;
	}
	
	public void setY(long y)
	{
		this.y = y;
	}
	
	public String getHotelNameKana()
	{
		return hotelNameKana;
	}
	
	public void setHotelNameKana(String hotelNameKana)
	{
		this.hotelNameKana = hotelNameKana;
	}
	
	public int getNumberOfRatings()
	{
		return numberOfRatings;
	}
	
	public void setNumberOfRatings(int numberOfRatings)
	{
		this.numberOfRatings = numberOfRatings;
	}
	
	public double getRating()
	{
		return rating;
	}
	
	public void setRating(double rating)
	{
		this.rating = rating;
	}
}
