package com.example.roomsearch;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	//じゃらん空室検索リクエストURL
	private final String REQUEST_URL = "http://jws.jalan.net/APIAdvance/StockSearch/V1/?";
/*
	private final HashMap REQUEST_PARAMS = new HashMap();
	REQUEST_PARAMS.put("key", "lib13022af0158");
	REQUEST_PARAMS.put("s_area", "400102");
*/
	//じゃらんAPIキー
	private final String API_KEY = "lib13022af0158";
	//エリアコード「福岡市（博多駅周辺・香椎・海の中道）」
	//http://www.jalan.net/jalan/doc/jws/data/area.html
	private final String AREA_CODE = "400102";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}