package com.note.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	public DatabaseHelper(Context context, String name, int version) {
		this(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	
	public void createTable(SQLiteDatabase db ,String name){
		String sql = "create table if not exists " + name + "(id int primary key,title varchar,content text,create_date varchar(20),modify_date varchar(20),pic blob,picpath varchar)";
		db.execSQL(sql);
	}
	
	public Cursor getAllTableName(SQLiteDatabase db){
		String sql = "select name from sqlite_master where type = 'table'";
		return db.rawQuery(sql, null);
	}
	
	public Cursor getTitleById(SQLiteDatabase db,String tableName,int id){
		String sql = "select * from " + tableName + "where id = " + id;
		return db.rawQuery(sql, null);
	}
	
	public void insert(SQLiteDatabase db ,String tableName ,ContentValues values){
		db.insert(tableName, null, values);
	}
}
