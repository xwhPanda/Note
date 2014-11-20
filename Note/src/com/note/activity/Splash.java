package com.note.activity;

import com.note.util.GlobalConsts;
import com.note.util.NoteApplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Splash extends Activity {
	private SharedPreferences preferences;
	private int count = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		initData();
		if (count == 0) {
			createTable(NoteApplication.dBHelper.getWritableDatabase());
			handler.sendEmptyMessageDelayed(1, 1000);
		}else {
			handler.sendEmptyMessageDelayed(1, 1000);
		}
	}
	
	private void initData(){
		preferences = getSharedPreferences("login_count", Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		count = preferences.getInt("count", 0);
		editor.putInt("count", count++);
		editor.commit();
	}
	
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				Intent intent = new Intent();
				intent.setClass(Splash.this, MainActivity.class);
				startActivity(intent);
//				overridePendingTransition(enterAnim, exitAnim);
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
}
