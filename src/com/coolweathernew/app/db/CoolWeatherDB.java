package com.coolweathernew.app.db;
import java.util.ArrayList;
import java.util.List;

import com.coolweathernew.app.model.City;
import com.coolweathernew.app.model.County;
import com.coolweathernew.app.model.Province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CoolWeatherDB {

	/**
	 * 数据库名
	 */
	public static final String DB_NAME="cool_weathernew";
	/**
	 * 数据库版本
	 */
	public static final  int VERSION=1;
	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db;
	/**
	 * 将构造方法私有化
	 */
	private CoolWeatherDB(Context context) {
		CoolWeatherOpenHelper dbHelper=new CoolWeatherOpenHelper(context, 
				DB_NAME, null, VERSION);
	
		db=dbHelper.getWritableDatabase();
	}
	/**
	 * 获取CoolWeatherDB实例
	 */
	public synchronized static CoolWeatherDB getInstance(Context context){
		if (coolWeatherDB==null) {
			coolWeatherDB=new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	
	
	/**
	 * 添加Province信息到数据库
	 */
	public void addProvince(){
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"北京","01"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"上海","02"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"天津","03"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"重庆","04"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"黑龙江","05"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"吉林","06"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"辽宁","07"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"内蒙古","08"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"河北","09"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"山西","10"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"陕西","11"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"山东","12"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"新疆","13"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"西藏","14"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"青海","15"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"甘肃","16"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"宁夏","17"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"河南","18"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"江苏","19"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"湖北","20"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"浙江","21"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"安徽","22"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"福建","23"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"江西","24"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"湖南","25"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"贵州","26"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"四川","27"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"广东","28"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"云南","29"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"广西","30"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"海南","31"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"香港","32"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"澳门","33"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"台湾","34"});
		//db.close();
	
	}
	
	/**
	 * 添加城市信息
	 */
	public void addCities(){
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"西安","101110101"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"铜川","101111001"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"宝鸡","101110901"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"咸阳","101110200"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"渭南","101110501"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"延安","101110300"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"汉中","101110801"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"榆林","101110401"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"安康","101110701"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"商洛","101110601"});
		//db.close();
	}
	
	/**
	 * 添加县级数据
	 */
	public void addCounties(){
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"岐山","101110905"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"凤翔","101110906"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"扶风","101110907"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"眉县","101110908"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"陇县","101110911"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"千阳","101110903"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"麟游","101110904"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"凤县","101110910"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"太白县","101110909"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"陈仓","101110912"});
		//db.close();
		
	}
	
	/**
	 * 将Province实例存储到数据库
	 */
	public void saveProvince(Province province){		
		ContentValues values=new ContentValues();
		if (province!=null) {
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert("Province", null, values);
		}
	}
	/**
	 * 从数据库读取全国所有的省份信息
	 */
	public List<Province> loadProvince(){
		List<Province> listProvince=new ArrayList<Province>();
		Cursor cursor=db.query("Province", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				Province province=new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceName(cursor.getString(
						cursor.getColumnIndex("province_name")));
				province.setProvinceCode(cursor.getString(
						cursor.getColumnIndex("province_code")));
				listProvince.add(province);
			} while (cursor.moveToNext());
		}
		
		return listProvince;
		
	}
	
	/**
	 * 将City实例存储到数据库
	 */
	
	public void saveCity(City city){
		ContentValues values=new ContentValues();
		if (city!=null) {
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_id", city.getProvinceId());	
			db.insert("City", null, values);
		}

	}
	/**
	 * 从数据库读取某省下的所有城市信息
	 */
	
	public List<City> loadCities(int provinceId){
		List<City> listCites=new ArrayList<City>();
		Cursor cursor=db.query("City", null,"province_id=?",
				new String[]{String.valueOf(provinceId)},null,null,null);
		if (cursor.moveToFirst()) {		
		do {
			City city=new City();
			city.setCityId(cursor.getInt(cursor.getColumnIndex("id")));
			city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
			city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
			city.setProvinceId(provinceId);
			listCites.add(city);
		} while (cursor.moveToNext());
		
		}
		return listCites;
	}
	
	/**
	 * 将County实例存储到数据库
	 */
	public void saveCounties(County county){
		ContentValues values=new ContentValues();
		if (county!=null) {
			values.put("county_name", county.getCountyName());
			values.put("county_code", county.getCountyCode());
			values.put("city_id", county.getCityId());
			db.insert("County", null, values);
		}
	}

	/**
	 * 从数据库读取某城市下的所有县的信息
	 */
	public List<County> loadCounty(int cityId){
		List<County> listCounty=new ArrayList<County>();
		Cursor cursor=db.query("County", null, "city_id=?", 
				new String[]{String.valueOf(cityId)}, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				County county=new County();
				county.setCountyId(cursor.getInt(cursor.getColumnIndex("id")));
				county.setCountyName(cursor.getString(
						cursor.getColumnIndex("county_name")));
				county.setCountyCode(cursor.getString(
						cursor.getColumnIndex("county_code")));
				county.setCityId(cityId);	
				listCounty.add(county);
			} while (cursor.moveToNext());
		}
		return listCounty;
		
	}
}
