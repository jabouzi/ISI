package com.skanderjabouzi.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CityDataSource {

	// Database fields
	private SQLiteDatabase database;
	private DBHelper dbHelper;

	public CityDataSource(Context context) {
		dbHelper = new DBHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
		Log.i("CityDataSource", "open");
	}
	
	public boolean isOpen()
	{
		if (database == null) return false;
		return database.isOpen();
	} 

	public void close() {
		dbHelper.close();
	}

	void addCity(City city) {
		ContentValues values = new ContentValues();
		database.insert("city", null, setCityData(city));
		database.close();
	}

	// Updating single City
	public int updateCity(City city) {
		ContentValues values = new ContentValues();
		// updating row
		return database.update("city", setCityData(city)," id = ?",
				new String[] { String.valueOf(city.getId()) });
	}

	// Deleting single City
	public void deleteCity(City city) {
		database.delete("city"," id = ?",
				new String[] { String.valueOf(city.getId()) });
		database.close();
	}

	// Getting single City
	City getCity(int id) {
		Cursor cursor = database.query("city", new String[] { "id",
						"city", "country"}," id = ?",
				new String[] { String.valueOf(id) }, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		City city = new City();
		city.setId((int) cursor.getLong(0));
		city.setCity(cursor.getString(1));
		city.setCountry(cursor.getString(2));
		cursor.close();

		// return City
		return city;
	}

	// Getting City Count
	public List<City> getAllCities() {
		List<City> cities = new ArrayList<City>();
		String countQuery = "SELECT  * FROM " + "city";
		Cursor cursor = database.rawQuery(countQuery, null);
		if (cursor.moveToFirst()) {
			while (!cursor.isAfterLast()) {
				City city = new City();
				city.setId((int) cursor.getLong(0));
				city.setCity(cursor.getString(1));
				city.setCountry(cursor.getString(2));
				Log.e("city", city.toString());
				cities.add(city);
				cursor.moveToNext();
			}
		}
		cursor.close();

		// return count
		return cities;
	}

	// Getting City Count
	public int getCityCount() {
		String countQuery = "SELECT  * FROM " + "city";
		Cursor cursor = database.rawQuery(countQuery, null);
		int count = cursor.getCount();
		cursor.close();

		// return count
		return count;
	}

	private ContentValues setCityData(City city) {
		ContentValues values = new ContentValues();
		values.put("id", city.getId());
		values.put("city", city.getCity());
		values.put("country", city.getCountry());

		return values;
	}
}
