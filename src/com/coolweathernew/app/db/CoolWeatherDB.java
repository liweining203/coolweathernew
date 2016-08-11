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
				DB_NAME, null, VERSION);
	
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
	 * ���Province��Ϣ�����ݿ�
	 */
	public void addProvince(){
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","01"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"�Ϻ�","02"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"���","03"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","04"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"������","05"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","06"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","07"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"���ɹ�","08"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"�ӱ�","09"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"ɽ��","10"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","11"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"ɽ��","12"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"�½�","13"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","14"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"�ຣ","15"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","16"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","17"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","18"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","19"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","20"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"�㽭","21"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","22"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","23"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","24"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","25"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","26"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"�Ĵ�","27"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"�㶫","28"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","29"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","30"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","31"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"���","32"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"����","33"});
//		db.execSQL("insert into Province(province_name,province_code) values(?,?) ",
//				new String[]{"̨��","34"});
		//db.close();
	
	}
	
	/**
	 * ��ӳ�����Ϣ
	 */
	public void addCities(){
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"����","101110101"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"ͭ��","101111001"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"����","101110901"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"����","101110200"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"μ��","101110501"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"�Ӱ�","101110300"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"����","101110801"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"����","101110401"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"����","101110701"});
//		db.execSQL("insert into City(city_name,city_code) values(?,?) ",
//				new String[]{"����","101110601"});
		//db.close();
	}
	
	/**
	 * ����ؼ�����
	 */
	public void addCounties(){
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"�ɽ","101110905"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"����","101110906"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"����","101110907"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"ü��","101110908"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"¤��","101110911"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"ǧ��","101110903"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"����","101110904"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"����","101110910"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"̫����","101110909"});
//		db.execSQL("insert into County(county_name,county_code) values(?,?) ",
//				new String[]{"�²�","101110912"});
		//db.close();
		
	}
	
	/**
	 * ��Provinceʵ���洢�����ݿ�
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
			values.put("province_id", city.getProvinceId());	
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
			city.setProvinceId(provinceId);
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
