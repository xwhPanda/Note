package com.note.util;

import com.note.db.DatabaseHelper;

import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class NoteApplication extends Application {

	public static DatabaseHelper dBHelper;
	private static String dBName = "note_db"; 
	private int dBVersion = 1;
	
	@Override
	public void onCreate() {
		super.onCreate();
		dBHelper = new DatabaseHelper(this, dBName, dBVersion);
		dBHelper.getWritableDatabase();
	}
	
	
}
