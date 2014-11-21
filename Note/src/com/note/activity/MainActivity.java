package com.note.activity;


import com.note.util.GlobalConsts;
import com.note.util.NoteApplication;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	private Button createDB;
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		db = NoteApplication.dBHelper.getWritableDatabase();
		createDB = (Button) findViewById(R.id.creatDB_btn);
		createDB.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.creatDB_btn) {
			NoteApplication.dBHelper.createTable(db, "杂谈");
			ContentValues cv = new ContentValues();
			cv.put("table_name", "杂谈");
			cv.put("title", "杂谈");
			NoteApplication.dBHelper.insert(db, GlobalConsts.TABLE_INFO_NAME, cv);
		}
	}
	
	protected void onDestroy() {
		super.onDestroy();
		if (db != null && db.isOpen()) {
			db.close();
		}
	};
}
	