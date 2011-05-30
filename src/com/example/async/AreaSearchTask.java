package com.example.async;

import org.apache.http.HttpStatus;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.adapter.AreaListAdapter;
import com.example.data.AreaSearchResult;
import com.example.data.AreaSearchResultFactory;
import com.example.data.BaseAreaData;
import com.example.data.LargeArea;
import com.example.data.Prefecture;
import com.example.data.Region;
import com.example.data.SearchArea;
import com.example.roomsearch.R;
import com.example.web.HttpServerIF;

public class AreaSearchTask extends AsyncTask<String, Void, Integer>
{
	private Context mContext;
	private ProgressDialog mDialog;
	private Spinner mSpinner;
	private int selected;				//default位置記憶用変数
	private AreaListAdapter mAdapter;

	public AreaSearchTask(Context context, Spinner spn)
	{
		mContext = context;
		mSpinner = spn;
		mAdapter = new AreaListAdapter(mContext);
	}

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();

		mDialog = new ProgressDialog(mContext);
		mDialog.setMessage(mContext.getString(R.string.dialog_recieving));
		mDialog.setIndeterminate(true);
		mDialog.show();
	}

	@Override
	protected Integer doInBackground(String... arg0)
	{
		int iRet = 0;
		String strUrl = arg0[0];
		int i = 0;

		HttpServerIF svr = new HttpServerIF();
		iRet = svr.requestText(strUrl);
		if(iRet == HttpStatus.SC_OK)
		{
			AreaSearchResultFactory factory = new AreaSearchResultFactory();
			AreaSearchResult result = (AreaSearchResult)factory.create(svr.getResText());
			SearchArea area = result.getArea();
			for(BaseAreaData region : area.getRegion())
			{
				Region reg = (Region)region;
				for(BaseAreaData prefecture : reg.getPrefecture())
				{
					Prefecture pref = (Prefecture)prefecture;
					for(BaseAreaData largeArea : pref.getLargeData())
					{
						LargeArea lArea = (LargeArea)largeArea;
						for(BaseAreaData smallArea : lArea.getSmallArea())
						{
							//小エリアコードをセット
							mAdapter.add(smallArea);
							//smallAreaのコードが138302（渋谷）なら
							if(smallArea.getCd().equals("138302"))
							{
								//default位置として記憶
								this.selected = i;
							}
							i++;
						}
					}
				}
			}
		}

		return new Integer(iRet);
	}

	@Override
	protected void onPostExecute(Integer result)
	{
		super.onPostExecute(result);

		if(result == HttpStatus.SC_OK)
		{
			mSpinner.setAdapter(mAdapter);
			//default位置を設定
			mSpinner.setSelection(this.selected);
		}
		else
		{
			Toast.makeText(mContext, mContext.getString(R.string.recieve_error), Toast.LENGTH_SHORT).show();
		}

		mDialog.dismiss();
	}
}
