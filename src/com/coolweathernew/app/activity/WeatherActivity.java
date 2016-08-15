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
	 * ������ʾ������
	 */
    private TextView cityNameText;
    /**
     * ��ʾ����ʱ��
     */
	private TextView publishTime;
	/**
	 * ��������
	 */
	private TextView weatherDespText;
	/**
	 * ��ʾ����1
	 */
	private TextView temp1Text;
	/**
	 * ��ʾ����2
	 */
	private TextView temp2Text;
	/**
	 * ������ʾ��ǰ����
	 */
	private TextView currentDateText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);
		//��ʼ�����ؼ�
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
			//���ؼ�����ʱ�Ͳ�ѯ����
			publishTime.setText("ͬ���С�������");
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			cityNameText.setVisibility(View.INVISIBLE);
			queryFromServer(countyCode);		
         	}else if (!TextUtils.isEmpty(cityCode)) {		
			publishTime.setText("ͬ���С�������");
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			cityNameText.setVisibility(View.INVISIBLE);
			queryFromServer(cityCode);
		}else {
			//û���ؼ����ž�ֱ����ʾ����
			showWeather();
		}
	}
	/**
	 * ���ݴ���ĵ�ַ������ȥ���������ѯ�������Ż���������Ϣ
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
					//������������ص�������Ϣ
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
						publishTime.setText("ͬ��ʧ��");
					}
				});
				
			}
		});
	}
	
	/**
	 * ���ļ��ж�ȡ�洢��������Ϣ������ʾ��������
	 */
     private void showWeather(){
    	 SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);
    	 cityNameText.setText(prefs.getString("city_name", ""));
    	 temp1Text.setText(prefs.getString("temp1",""));
    	 temp2Text.setText(prefs.getString("temp2",""));
    	 weatherDespText.setText(prefs.getString("weather_desp", ""));
    	 publishTime.setText("����"+prefs.getString("publish_time", "")+"����");
    	 currentDateText.setText(prefs.getString("current_date", ""));
    	 weatherInfoLayout.setVisibility(View.VISIBLE);
    	 cityNameText.setVisibility(View.VISIBLE);
    	 
     }

}
