package com.example.roomsearch;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.async.AreaSearchTask;
import com.example.async.RoomSearchTask;
import com.example.data.BaseAreaData;

public class MainActivity extends ListActivity
	implements OnClickListener, OnItemSelectedListener
{
	//じゃらん空室検索リクエストURL
	private final String REQUEST_URL = "http://jws.jalan.net/APIAdvance/StockSearch/V1/?";
	//じゃらんエリアコード一覧リクエストURL
	private final String AREA_REQUEST_URL = "http://jws.jalan.net/APICommon/AreaSearch/V1/?";

 /*パラメータを連想配列で処理したいんだけれども...
	private HashMap<String, String> params = new HashMap<String, String>()
	{
		{
			put("key",		"lib13022af0158");
			put("s_area",	"400102");
		}
	};
*/

	//じゃらんAPIキー
	private final String KEY = "lib13022af0158";
	//エリアコード「福岡市（博多駅周辺・香椎・海の中道）」
	//http://www.jalan.net/jalan/doc/jws/data/area.html
//	private final String S_AREA = "400102";

	private RoomSearchTask mTask;
	private AreaSearchTask mAreaTask;
	private int mCurrentPage = 0;
	private int mPageCount = 10;
	private Spinner spnPlace;
	private String mAreaCode;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        int[] iButtons = new int[]{
        		R.id.btnPrev,
        		R.id.btnNext
        };
        for(int iButton : iButtons)
        {
        	Button btn = (Button)findViewById(iButton);
        	btn.setOnClickListener(this);
        }

        spnPlace = (Spinner)findViewById(R.id.spnplace);
        spnPlace.setOnItemSelectedListener(this);
    }

    @Override
    public void onResume()
    {
    	super.onResume();

    	mAreaTask = new AreaSearchTask(this, spnPlace);
    	mAreaTask.execute(AREA_REQUEST_URL + "key=" + this.KEY);
    }

    @Override
    public void onPause()
    {
    	super.onPause();

    	if(mAreaTask != null && !mAreaTask.isCancelled())
    	{
    		mAreaTask.cancel(true);
    	}

    	if(mTask != null && !mTask.isCancelled())
    	{
    		mTask.cancel(true);
    	}
    }

    @Override
    public void onClick(View v)
    {
    	int id = v.getId();
    	switch(id)
    	{
	    	case R.id.btnPrev:
	    	{
	    		mCurrentPage -= mPageCount;
	    		if(mCurrentPage < 1)
	    		{
	    			mCurrentPage = 1;
	    		}
	    		ListView list = (ListView)findViewById(android.R.id.list);
	    		TextView txtPage = (TextView)findViewById(R.id.txtPage);
	    		mTask = new RoomSearchTask(MainActivity.this, list, txtPage);
	    		mTask.execute(getURL());
	    		break;
	    	}
	    	case R.id.btnNext:
	    	{
	    		if(mTask.getResults() != null)
	    		{
	    			mCurrentPage += mPageCount;
	    			if(mCurrentPage > mTask.getResults().getNumberOfResults())
	    			{
	    				mCurrentPage = mTask.getResults().getNumberOfResults() - mPageCount;
	    			}
		    		ListView list = (ListView)findViewById(android.R.id.list);
		    		TextView txtPage = (TextView)findViewById(R.id.txtPage);
		    		mTask = new RoomSearchTask(MainActivity.this, list, txtPage);
		    		mTask.execute(getURL());
	    		}
	    		break;
	    	}
	    	default:
	    		break;
    	}
    }

    private String getURL()
    {
    	return this.REQUEST_URL + "key=" + this.KEY + "&s_area=" + mAreaCode + "&start=" + mCurrentPage;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapter, View v, int position, long id)
    {
    	mCurrentPage = 1;
    	ListView list = (ListView)findViewById(android.R.id.list);
    	TextView txtPage = (TextView)findViewById(R.id.txtPage);
    	BaseAreaData data = (BaseAreaData)adapter.getItemAtPosition(position);
    	mAreaCode = data.getCd();
    	mTask = new RoomSearchTask(MainActivity.this, list, txtPage);
    	mTask.execute(getURL());
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0)
    {

    }
}