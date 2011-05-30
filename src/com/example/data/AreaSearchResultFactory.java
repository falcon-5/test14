package com.example.data;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

public class AreaSearchResultFactory extends BaseResponseFactory
{
	private AreaSearchResult mResult = null;
	private SearchArea mArea = null;
	private Region mRegion = null;
	private Prefecture mPref = null;
	private LargeArea mLargeArea = null;
	private BaseAreaData mSmallArea = null;

	@Override
	protected void onStartTag(XmlPullParser parser) throws Exception
	{
		String strTagName = parser.getName();
		if(strTagName.equals("Results"))
		{
			//Resultsタグが見つかったのでインスタンス作成
			mResult = new AreaSearchResult();
		}

		if(mResult != null)
		{
			if(strTagName.equals("Area"))
			{
				//Areaタグが見つかったときにSearchArea追加
				mArea = new SearchArea();
			}
			else if(strTagName.equals("APIVersion"))
			{
				//APIversion
			}
			else
			{
				//コード、名称の退避
				String cd = getAttribute(parser, "cd");
				String name = getAttribute(parser, "name");

				if(strTagName.equals("Region"))
				{
					if(mArea.getRegion() == null)
					{
						mArea.setRegion(new ArrayList<BaseAreaData>());
					}
					mRegion = new Region();
					mRegion.setCd(cd);
					mRegion.setName(name);
					mRegion.setPrefecture(new ArrayList<BaseAreaData>());
				}
				else if(strTagName.equals("Prefecture"))
				{
					mPref = new Prefecture();
					mPref.setCd(cd);
					mPref.setName(name);
					mPref.setLargeData(new ArrayList<BaseAreaData>());
				}
				else if(strTagName.equals("LargeArea"))
				{
					mLargeArea = new LargeArea();
					mLargeArea.setCd(cd);
					mLargeArea.setName(name);
					mLargeArea.setSmallArea(new ArrayList<BaseAreaData>());
				}
				else if(strTagName.equals("SmallArea"))
				{
					mSmallArea = new BaseAreaData();
					mSmallArea.setCd(cd);
					mSmallArea.setName(name);
				}
			}
		}
	}

	@Override
	protected void onEndTag(XmlPullParser parser)
	{
		String strTagName = parser.getName();

		if(mResult != null)
		{
			if(strTagName.equals("Area"))
			{
				mResult.setArea(mArea);
			}
			else if(strTagName.equals("APIVersion"))
			{
				mResult.setApiVersion(mText);
			}
			else
			{
				if(strTagName.equals("Region"))
				{
					mArea.getRegion().add(mRegion);
				}
				else if(strTagName.equals("Prefecture"))
				{
					mRegion.getPrefecture().add(mPref);
				}
				else if(strTagName.equals("LargeArea"))
				{
					mPref.getLargeData().add(mLargeArea);
				}
				else if(strTagName.equals("SmallArea"))
				{
					mLargeArea.getSmallArea().add(mSmallArea);
				}
			}
		}
	}

	@Override
	protected BaseData getResponse()
	{
		return mResult;
	}
}
