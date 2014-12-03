package com.note.util;

import com.note.activity.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class ItemView extends LinearLayout {
	private Scroller mScroller;

	public ItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public ItemView(Context context) {
		super(context);
		initView(context);
	}
	
	private void initView(Context context){
		mScroller = new Scroller(context);
		View.inflate(context, R.layout.list_adapter_item, this);
	}
	
	public void shrink(){
		if (getScrollX() != 0) {
			this.smoothScrollto(0,0);
		}
	}
	
	private void smoothScrollto(int x , int y){
		int scrollX = getScrollX();
		mScroller.startScroll(scrollX, 0, x - scrollX, 0);
		invalidate();
	}
	
	@Override
	public void computeScroll() {
		if (mScroller.computeScrollOffset()) {
			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			invalidate();
		}
	}
	
	public void touchEvent(MotionEvent event){
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			
			break;

		case MotionEvent.ACTION_MOVE:
			break;
		
		case MotionEvent.ACTION_UP:
			break;
		}
	}
}
