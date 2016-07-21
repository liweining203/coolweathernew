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
	 * ���ݿ���
	 */
	public static final String DB_NAME="cool_weathernew";
	/**
	 * ���ݿ�汾
	 */
	public static final  int VERSION=1;
	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db;
	/**
	 * �����췽��˽�л�
	 */
	private CoolWeatherDB(Context context) {
		CoolWeatherOpenHelper dbHelper=new CoolWeatherOpenHelper(context, 
				DB_NAME, null, VERSION, null);
	
		db=dbHelper.getWritableDatabase();
	}
	/**
	 * ��ȡCoolWeatherDBʵ��
	 */
	public synchronized static CoolWeatherDB getInstance(Context context){
		if (coolWeatherDB==null) {
			coolWeatherDB=new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	
	/**
	 * ��Provinceʵ���洢�����ݿ�
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
	 * �����ݿ��ȡȫ�����е�ʡ����Ϣ
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
	 * ��Cityʵ���洢�����ݿ�
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
	 * �����ݿ��ȡĳʡ�µ����г�����Ϣ
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
	 * ��Countyʵ���洢�����ݿ�
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
	 * �����ݿ��ȡĳ�����µ������ص���Ϣ
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
