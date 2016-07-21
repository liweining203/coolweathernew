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
				DB_NAME, null, VERSION, null);
	
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
	 * 将Province实例存储到数据库
	 */
	public void saveProvince(Province province){
		if (province!=null) {
			ContentValues values=new ContentValues();
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
			values.put("province_id", city.getProviceId());	
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
			city.setProviceId(provinceId);
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
