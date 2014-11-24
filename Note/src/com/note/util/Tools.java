package com.note.util;

import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;

public class Tools {
	public static int width;
	public static int height;
	
	public static void init(Context context) {
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		width = display.getWidth();
		height = display.getHeight();
	}
	
	public static void setViewWidth(View view , int width){
		ViewGroup.LayoutParams lp = view.getLayoutParams();
		lp.width = width;
		view.setLayoutParams(lp);
	}
	
	public static void setViewHeight(View view , int height){
		ViewGroup.LayoutParams lp = view.getLayoutParams();
		lp.height = height;
		view.setLayoutParams(lp);
	}
	
	public static void setViewMargin(View view ,int left , int top , int right , int bottom){
		ViewGroup.MarginLayoutParams mlp = (MarginLayoutParams) view.getLayoutParams();
		mlp.leftMargin = left;
		mlp.topMargin = top;
		mlp.rightMargin = right;
		mlp.bottomMargin = bottom;
		view.setLayoutParams(mlp);
	}
}
