package com.note.util;

import android.R.integer;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;

public class MyAnimations {
	private static int xOffset = 10;
	
	public static void initOffset(Context context){
		xOffset = (int)(5 * context.getResources().getDisplayMetrics().density);
	}
	
	public static Animation getRotateAnimation(float fromDegress, float toDegress,int duration){
		RotateAnimation rotateAnimation = new RotateAnimation(fromDegress, toDegress,
				Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
		rotateAnimation.setFillAfter(true);
		rotateAnimation.setDuration(duration);
		return rotateAnimation;
	}
	
	public static void startAnimationsOut(ViewGroup viewGroup , int duration){
		for(int i = 0 ; i < viewGroup.getChildCount() ; i++ ){
			ImageButton imageButton = (ImageButton) viewGroup.getChildAt(i);
			imageButton.setVisibility(View.VISIBLE);
			MarginLayoutParams mlParams = (MarginLayoutParams) imageButton.getLayoutParams();
			Animation animation = new TranslateAnimation(mlParams.rightMargin - xOffset, 0, 0, 0);
			animation.setDuration(duration);
			animation.setFillAfter(true);
			animation.setStartOffset((300 - i * 100) / (viewGroup.getChildCount() - 1));
			animation.setInterpolator(new OvershootInterpolator(2F));
			imageButton.startAnimation(animation);
		}
	}
	
	public static void startAnimationsIn(ViewGroup viewGroup ,int duration){
		for(int i = 0; i < viewGroup.getChildCount(); i++){
			final ImageButton imageButton = (ImageButton) viewGroup.getChildAt(i);
			MarginLayoutParams mlParams = (MarginLayoutParams) imageButton.getLayoutParams();
			Animation animation = new TranslateAnimation(0, mlParams.rightMargin - xOffset, 0, 0);
			animation.setDuration(duration);
			animation.setFillAfter(true);
			animation.setStartOffset((300 + i * 50) / (viewGroup.getChildCount() - 1));
			animation.setInterpolator(new AnticipateInterpolator(2));
			animation.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					imageButton.setVisibility(View.GONE);
				}
			});
			imageButton.startAnimation(animation);
		}
	}
}
