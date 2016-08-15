package com.coolweathernew.app.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.coolweathernew.app.db.CoolWeatherDB;
import com.coolweathernew.app.R;
import com.coolweathernew.app.model.City;
import com.coolweathernew.app.model.County;
import com.coolweathernew.app.model.Province;
import com.coolweathernew.app.util.HttpCallBackListener;
import com.coolweathernew.app.util.HttpUtil;
import com.coolweathernew.app.util.Utility;

public class ChooseAreaActivity extends Activity {

    public static final int LEVEL_PROVINCE = 0;
    public static final int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;

    private ProgressDialog progressDialog;
    private TextView titleText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private CoolWeatherDB coolWeatherDB;
    private List<String> dataList = new ArrayList<String>();
    
    /**
     * 省市县列表
     */
    private List<Province> provinceList;
  
    private List<City> cityList;
   
    private List<County> countyList;
    /**
     * 选中的省
     */
    private Province selectedProvince;
    /**
     * 选中的市
     */
    private City selectedCity;
    /**
     * 当前级别
     */
    private int currentLevel;
    /**
     * 
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getBoolean("city_selected", false)) {
			Intent intent=new Intent(this,WeatherActivity.class);
			startActivity(intent);
			finish();
			return;
		}
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.choose_area);
        listView = (ListView) findViewById(R.id.list_view);
        titleText = (TextView) findViewById(R.id.title_text);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        coolWeatherDB = CoolWeatherDB.getInstance(this);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int index,
                                    long arg3) {
                if (currentLevel == LEVEL_PROVINCE) {
                    selectedProvince = provinceList.get(index);
                    queryCities();
                } else if (currentLevel == LEVEL_CITY) {
                    selectedCity = cityList.get(index);
                    queryCounties(); 
                	String cityCode=cityList.get(index).getCityCode();
                	Intent intent=new Intent(ChooseAreaActivity.this,
                			WeatherActivity.class);
                	intent.putExtra("city_code", cityCode);
                	startActivity(intent);
                	finish();
                } else if (currentLevel == LEVEL_COUNTY) {
                	//String cityCode=cityList.get(index).getCityCode();
                	String countyCode=countyList.get(index).getCountyCode();
                	Intent intent=new Intent(ChooseAreaActivity.this,
                			WeatherActivity.class);
                	//intent.putExtra("city_code", cityCode);
                	intent.putExtra("county_code", countyCode);
                	startActivity(intent);
                	finish();
                }
            }
        });
        queryProvinces(); 
    }
    /**
     * 从数据库查询省级数据
     */
    private void queryProvinces() {
        provinceList = coolWeatherDB.loadProvince();
        if (provinceList.size() > 0) {
            dataList.clear();
            for (Province province : provinceList) {
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText("中国");
            currentLevel = LEVEL_PROVINCE;
        } else {

        	initProvince();
        }
    }
    /**
	 *  解析和处理省级数据
	 */

	public void initProvince(){
		String provinces="01|北京,02|上海,03|天津,04|重庆,05|黑龙江,06|吉林,07|辽宁,08|内蒙古,"
				+ "09|河北,10|山西,11|陕西,12|山东,13|新疆,14|西藏,15|青海,16|甘肃,17|宁夏,"
				+ "18|河南,19|江苏,20|湖北,21|浙江,22|安徽,23|福建,24|江西,25|湖南,26|贵州,"
				+ "27|四川,28|广东,29|云南,30|广西,31|海南,32|香港,33|澳门,，34|台湾";
		if (!TextUtils.isEmpty("provinces")) {
			String[] allProvinces=provinces.split(",");
			if (allProvinces!=null&&allProvinces.length>0) {
				for (String pro : allProvinces) {
					String[] array=pro.split("\\|");
					Province province=new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//将解析出来的数据存储到Province表中
					coolWeatherDB.saveProvince(province);
				}
				
			}	
		}
	}
	/**
   	 * 解析和处理省市级数据
   	 */

   	public void initCity(){
   	    String 	subcity=null;
   		String city10="太原:101100101,临汾:101100701,运城:101100801,朔州:101100901,"
   				+ "忻州:101101001,长治:101100501,大同:101100201,阳泉:101100301,"
   				+ "晋中:101100401,晋城:101100601,吕梁:101101100";
   		String city11="西安:101110101,延安:101110300,榆林:101110401,铜川:101111001,"
   				+ "商洛:101110601,安康:101110701,汉中:101110801,宝鸡:101110901,"
   				+ "咸阳:101110200,渭南:101110501";
   		String city12="济南:101120101,潍坊:101120601,临沂:101120901,菏泽:101121001,"
   				+ "滨州:101121101,东营:101121201,威海:101121301,枣庄:101121401,"
   				+ "日照:101121501,莱芜:101121601,聊城:101121701,青岛:101120201,"
   				+ "淄博:101120301,德州:101120401,烟台:101120501,济宁:101120701,"
   				+ "泰安:101120801";
   		switch (Integer.parseInt(selectedProvince.getProvinceCode())) {
   		case 10:
   			subcity=city10;
   			break;
           case 11:
           	subcity=city11;
   			break;
           case 12:
           	subcity=city12;
   			break;
   		default:
   			break;
   		}
   		if (!TextUtils.isEmpty("subcity")) {
   			String[] allCitys=subcity.split(",");
   			if (allCitys!=null&&allCitys.length>0) {
   				for (String cit : allCitys) {
   					String[] array=cit.split(":");
   					City city=new City();
   					city.setCityName(array[0]);
   					city.setCityCode(array[1]);
   					city.setProvinceId(selectedProvince.getId());
   					//将解析出来的数据存储到Province表中
   					coolWeatherDB.saveCity(city);
   				}	
   				
   			}	
   		}
   	}
	/**
	 * 解析和处理县级数据
	 */
	public  void initCounty(){
	    String 	counties=null;
		String county101="太原:101100101,清徐:101100102,阳曲:101100103,娄烦:101100104,"
				+ "古交:101100105";
		String county901="宝鸡:101110901,凤翔:101110906,岐山:101110905,扶风:101110908,"
				+ "眉县:101110908,陇县:101110911,千阳:101110903,麟游:101110904,"
				+ "凤县:101110910,太白:101110909,陈仓:101110912";
		switch (Integer.parseInt(selectedCity.getCityCode())) {
		case 101100101:
			counties=county101;
			break;
        case 101110901:
        	counties=county901;
			break;
		default:
			break;
		}
		if (!TextUtils.isEmpty("counties")) {
			String[] allCounties=counties.split(",");
			if (allCounties!=null&&allCounties.length>0) {
				for (String coun : allCounties) {
					String[] array=coun.split(":");
					County county=new County();
					county.setCountyName(array[0]);
					county.setCountyCode(array[1]);
					county.setCityId(selectedCity.getCityId());
					//将解析出来的数据存储到Province表中
					coolWeatherDB.saveCounties(county);
				}	
				
			}	
		}
	}

    /**
     * 从数据库查询市级数据
     */
    private void queryCities() {
        cityList = coolWeatherDB.loadCities(selectedProvince.getId());
        if (cityList.size() > 0) {
            dataList.clear();
            for (City city : cityList) {
                dataList.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText(selectedProvince.getProvinceName());
            currentLevel = LEVEL_CITY;
        } else {
           initCity();
        }
    }

    
    /**
     * 从数据库查询县级数据
     */
    private void queryCounties() {
        countyList = coolWeatherDB.loadCounty(selectedCity.getCityId());
        if (countyList.size() > 0) {
            dataList.clear();
            for (County county : countyList) {
                dataList.add(county.getCountyName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText(selectedCity.getCityName());
            currentLevel = LEVEL_COUNTY;
        } else {
            initCounty();
        }
    }
    
    /**
     * 根据代号和类型从服务器查询数据
     */
    private void queryFromServer(final String code, final String type) {
//        String address;
//        if (!TextUtils.isEmpty(code)) {
//            address = "http://www.weather.com.cn/data/list3/city" + code
//                    + ".xml";
//        } else {
//            address = "http://www.weather.com.cn/data/list3/city.xml";
//        }
//        showProgressDialog();
//        HttpUtil.sendHttpRequest(address, new HttpCallBackListener() {
//			
//			@Override
//			public void onFinish(String response) {
//				// TODO Auto-generated method stub
//				boolean result = false;
//                if ("province".equals(type)) {
//                    result = Utility.handleProvincesResponse(coolWeatherDB,
//                            response);
//                } else if ("city".equals(type)) {
//                    result = Utility.handleCitiesResponse(coolWeatherDB,
//                            response, selectedProvince.getId());
//                } else if ("county".equals(type)) {
//                    result = Utility.handleCountiesResponse(coolWeatherDB,
//                            response, selectedCity.getCityId());
//                }
//                if (result) {
//                    // 切换到主线程runOnUiThread()
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            closeProgressDialog();
//                            if ("province".equals(type)) {
//                                queryProvinces();
//                            } else if ("city".equals(type)) {
//                                queryCities();
//                            } else if ("county".equals(type)) {
//                                queryCounties();
//                            }
//                        }
//                    });
//                }
//			}
//			
//			@Override
//			public void onError(Exception e) {
//				// TODO Auto-generated method stub
//				runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        closeProgressDialog();
//                        Toast.makeText(ChooseAreaActivity.this, "加载失败！",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }	
//		});             
    }

    /**
     * 
     */
    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("数据加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    /**
     * 
     */
    private void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /**
     * 捕获BackPressed键，按级别显示
     */
    @Override
    public void onBackPressed() {
        if (currentLevel == LEVEL_COUNTY) {
            queryCities();
        } else if (currentLevel == LEVEL_CITY) {
            queryProvinces();
        } else {
            finish();
        }
    }

}