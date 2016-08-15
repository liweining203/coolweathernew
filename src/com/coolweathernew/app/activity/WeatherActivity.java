package com.coolweathernew.app.activity;

import android.app.Activity;
import android.app.DownloadManager.Query;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolweathernew.app.R;
import com.coolweathernew.app.model.County;
import com.coolweathernew.app.util.HttpCallBackListener;
import com.coolweathernew.app.util.HttpUtil;
import com.coolweathernew.app.util.Utility;
public class WeatherActivity extends Activity{
	private LinearLayout weatherInfoLayout;
	/**
	 * 用于显示城市名
	 */
    private TextView cityNameText;
    /**
     * 显示发布时间
     */
	private TextView publishTime;
	/**
	 * 描述天气
	 */
	private TextView weatherDespText;
	/**
	 * 显示天气1
	 */
	private TextView temp1Text;
	/**
	 * 显示天气2
	 */
	private TextView temp2Text;
	/**
	 * 用于显示当前日期
	 */
	private TextView currentDateText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);
		//初始化各控件
		weatherInfoLayout=(LinearLayout) findViewById(R.id.weather_info_layout);
		cityNameText=(TextView) findViewById(R.id.city_name);
		publishTime=(TextView) findViewById(R.id.publish_time);
		weatherDespText=(TextView) findViewById(R.id.weather_desp);
		temp1Text=(TextView) findViewById(R.id.temp1);
		temp2Text=(TextView) findViewById(R.id.temp2);
		currentDateText=(TextView) findViewById(R.id.current_date);
		String cityCode=getIntent().getStringExtra("city_code");
		String countyCode=getIntent().getStringExtra("county_code");
		if (!TextUtils.isEmpty(countyCode)) {
			//有县级代号时就查询天气
			publishTime.setText("同步中。。。。");
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			cityNameText.setVisibility(View.INVISIBLE);
			queryFromServer(countyCode);		
         	}else if (!TextUtils.isEmpty(cityCode)) {		
			publishTime.setText("同步中。。。。");
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			cityNameText.setVisibility(View.INVISIBLE);
			queryFromServer(cityCode);
		}else {
			//没有县级代号就直接显示天气
			showWeather();
		}
	}
	/**
	 * 根据传入的地址和类型去向服务器查询天气代号活着天气信息
	 */
	private void queryFromServer(final String code){
		 String address = null;
		 if (!TextUtils.isEmpty(code)) {
			 address="http://www.weather.com.cn/data/cityinfo/"+
						code+".html";
		}		
		HttpUtil.sendHttpRequest(address, new HttpCallBackListener() {
			
			@Override
			public void onFinish( final String response) {
					//处理服务器返回的天气信息
					Utility.handleWeatherReponse(WeatherActivity.this, response);
					runOnUiThread( new Runnable() {
						public void run() {
							showWeather();
						}
					});
			}
			
			@Override
			public void onError(Exception e) {
				// TODO Auto-generated method stub
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						publishTime.setText("同步失败");
					}
				});
				
			}
		});
	}
	
	/**
	 * 从文件中读取存储的天气信息，并显示到界面上
	 */
     private void showWeather(){
    	 SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);
    	 cityNameText.setText(prefs.getString("city_name", ""));
    	 temp1Text.setText(prefs.getString("temp1",""));
    	 temp2Text.setText(prefs.getString("temp2",""));
    	 weatherDespText.setText(prefs.getString("weather_desp", ""));
    	 publishTime.setText("今天"+prefs.getString("publish_time", "")+"发布");
    	 currentDateText.setText(prefs.getString("current_date", ""));
    	 weatherInfoLayout.setVisibility(View.VISIBLE);
    	 cityNameText.setVisibility(View.VISIBLE);
    	 
     }

}
