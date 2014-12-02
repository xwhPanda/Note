package com.note.activity;

import com.note.adapter.ListAdapter;
import com.note.util.GlobalConsts;
import com.note.util.MyAnimations;
import com.note.util.NiftyDialogBuilder;
import com.note.util.NoteApplication;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener{
	private SQLiteDatabase db;
	private RelativeLayout show_hide_btn;
	private RelativeLayout add_btn_wrapper;
	private ImageView show_hide_icon;
	private ImageButton add_btn;
	private ImageButton about_btn;
	private ListView mListView;
	private boolean isShowing;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		MyAnimations.initOffset(this);
		db = NoteApplication.dBHelper.getWritableDatabase();
		show_hide_btn = (RelativeLayout) findViewById(R.id.show_hide_btn);
		add_btn_wrapper = (RelativeLayout) findViewById(R.id.add_btn_wrapper);
		show_hide_icon = (ImageView) findViewById(R.id.show_hide_icon);
		add_btn = (ImageButton) findViewById(R.id.add_btn);
		about_btn = (ImageButton) findViewById(R.id.about_btn);
		mListView = (ListView) findViewById(R.id.listview);
		
		show_hide_btn.setOnClickListener(this);
		add_btn.setOnClickListener(this);
		about_btn.setOnClickListener(this);
		
		mListView.setAdapter(new ListAdapter(this, GlobalConsts.TITLES));
	}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.add_btn) {
			new NiftyDialogBuilder(this,R.style.MyDialogTheme)
			.withType(GlobalConsts.SAVE_SORT)
			.withTipVisible(View.INVISIBLE)
			.withContentVisible(View.VISIBLE)
			.show();
		}else if (v.getId() == R.id.show_hide_btn) {
			if (isShowing) {
				MyAnimations.startAnimationsIn(add_btn_wrapper, 300);
				show_hide_icon.startAnimation(MyAnimations.getRotateAnimation(-270, 0, 300));
				isShowing = false;
			}else {
				MyAnimations.startAnimationsOut(add_btn_wrapper, 300);
				show_hide_icon.startAnimation(MyAnimations.getRotateAnimation(0, -270, 300));
				isShowing = true;
			}
		}
	}
	
	protected void onDestroy() {
		super.onDestroy();
		if (db != null && db.isOpen()) {
			db.close();
		}
	};
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			System.exit(0);
			return false;
		}else {
			return super.onKeyDown(keyCode, event);
		}
	}
}
	