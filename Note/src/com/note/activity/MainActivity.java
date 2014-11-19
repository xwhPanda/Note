package com.note.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.database.R;
import com.note.db.DatabaseHelper;
import com.note.util.NoteApplication;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDebug.DbStats;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	private Button createDB;
	private ContentValues values;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		createDB = (Button) findViewById(R.id.creatDB_btn);
		createDB.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.creatDB_btn) {
			SQLiteDatabase db = NoteApplication.dBHelper.getWritableDatabase();
			NoteApplication.dBHelper.createTable(db, "note_1");
			NoteApplication.dBHelper.getAllTableName(db);
			NoteApplication.dBHelper.insert(db, "note_1", getValues());
		}
	}
	
	private ContentValues getValues(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date(System.currentTimeMillis());
		String dateString = dateFormat.format(currentDate);
		ContentValues values = new ContentValues();
		values.put("id", 1);
		values.put("title", "title_1");
		values.put("content", "你是SB吧!2333");
		values.put("create_date", dateString);
		values.put("modify_date", dateString);
		return values;
	}
}
	