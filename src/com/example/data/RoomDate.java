package com.example.data;

public class RoomDate {
	private int date;
	private int month;
	private int year;
	private int rate;		//1泊あたりの料金
	private int stock;		//空室数
	
	public int getDate()
	{
		return date;
	}
	
	public void setDate(int date)
	{
		this.date = date;
	}

	public int getMonth()
	{
		return month;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}

	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}

	public int getRate()
	{
		return rate;
	}
	
	public void setRate(int rate)
	{
		this.rate = rate;
	}

	public int getStock()
	{
		return stock;
	}
	
	public void setStock(int stock)
	{
		this.stock = stock;
	}
}
