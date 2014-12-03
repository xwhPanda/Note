package com.note.util;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class DeleteListView extends ListView {

	public DeleteListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public DeleteListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DeleteListView(Context context) {
		super(context);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		Log.e("TAG", "DeleteListView");
		return true;
	}
}
