package com.note.activity;

import com.note.util.GlobalConsts;
import com.note.util.NoteApplication;
import com.note.util.TitleInfo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class Splash extends Activity {
	private SharedPreferences preferences;
	private int count = 0;
	private SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		initData();
		if (count == 0) {
			createTable(db);
		}
		initDBData();
		handler.sendEmptyMessageDelayed(1, 1000);
	}
	
	private void initData(){
		db = NoteApplication.dBHelper.getWritableDatabase();
		preferences = getSharedPreferences("login_count", Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		count = preferences.getInt("count", 0);
		editor.putInt("count", count+1);
		editor.commit();
	}
	
	private void initDBData(){
		Cursor cursor = NoteApplication.dBHelper.getAllInfo(db, GlobalConsts.TABLE_INFO_NAME);
		while(cursor.moveToNext()){
			TitleInfo info = new TitleInfo();
			info.setId(cursor.getInt(cursor.getColumnIndex("id")));
			info.setTable_name(cursor.getString(cursor.getColumnIndex("table_name")));
			info.setTitle(cursor.getString(cursor.getColumnIndex("title")));
			GlobalConsts.TITLES.add(info);
		}
		cursor.close();
	}
	
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				Intent intent = new Intent();
				intent.setClass(Splash.this, MainActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				finish();
			}
		};
	};
	
	private void createTable(SQLiteDatabase db){
		NoteApplication.dBHelper.createTableInfoTable(db, GlobalConsts.CREATE_TABLE_INFO_TABEL);
		for(int i =0 ; i < GlobalConsts.SORTS_TABLE_NAME.length ; i ++){
			ContentValues cv = new ContentValues();
			cv.put("id", i);
			cv.put("table_name", GlobalConsts.SORTS_TABLE_NAME[i]);
			cv.put("title", GlobalConsts.SORTS[i]);
			NoteApplication.dBHelper.insert(db, GlobalConsts.TABLE_INFO_NAME, cv);
			NoteApplication.dBHelper.createTable(db, GlobalConsts.SORTS_TABLE_NAME[i]);
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
