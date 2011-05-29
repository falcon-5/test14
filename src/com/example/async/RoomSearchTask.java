package com.example.async;

import org.apache.http.HttpStatus;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.PlanListAdapter;
import com.example.data.RoomSearchResults;
import com.example.data.RoomSearchResultsFactory;
import com.example.roomsearch.R;
import com.example.web.HttpServerIF;

public class RoomSearchTask extends AsyncTask<String, Void, Integer>
{
	private Context mContext;
	private ProgressDialog mDialog;
	private ListView mList;
	private RoomSearchResults mResults;

	public RoomSearchTask(Context context, ListView list)
	{
		mContext = context;
		mList = list;
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

		HttpServerIF svr = new HttpServerIF();
		iRet = svr.requestText(strUrl);
		if(iRet == HttpStatus.SC_OK)
		{
			RoomSearchResultsFactory factory = new RoomSearchResultsFactory();
			mResults = (RoomSearchResults)factory.create(svr.getResText());
		}
		else
		{
			mResults = null;
		}
		return new Integer(iRet);
	}

	@Override
	protected void onPostExecute(Integer result)
	{
		super.onPostExecute(result);

		if(result == HttpStatus.SC_OK)
		{
			PlanListAdapter adapter = new PlanListAdapter(mContext, mResults.getPlan());
			mList.setAdapter(adapter);
		}
		else
		{
			Toast.makeText(mContext, mContext.getString(R.string.recieve_error), Toast.LENGTH_SHORT).show();
		}
		mDialog.dismiss();
	}

}
