package com.database.test;

import com.example.database.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	private Button createDB;

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
			DatabaseHelper dBHelper = new DatabaseHelper(this, "TestDB", null, 1);
			dBHelper.getWritableDatabase();
		}
	}

}
