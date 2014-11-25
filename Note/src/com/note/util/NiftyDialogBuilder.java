package com.note.util;

import com.note.activity.R;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NiftyDialogBuilder extends Dialog implements DialogInterface,OnClickListener{
	private View mView;
	private RelativeLayout mMianLayout;
	private LinearLayout mParentLayout;
	private RelativeLayout mTitleLayout;
	private RelativeLayout mContentLayout;
	private RelativeLayout mBtnLayout;
	private TextView mTitle;
	private TextView mTip;
	private EditText mContent;
	private Button mLeftBtn;
	private Button mRightBtn;

	public NiftyDialogBuilder(Context context) {
		super(context);
		initView(context);
	}
	
	public NiftyDialogBuilder(Context context , int theme) {
		super(context , theme);
		initView(context);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
		lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
		getWindow().setAttributes(lp);
	}

	private void initView(Context context){
		mView = View.inflate(context, R.layout.dialog_layout, null);
		setContentView(mView);
		mMianLayout = (RelativeLayout) mView.findViewById(R.id.main_layout);
		mParentLayout = (LinearLayout) mView.findViewById(R.id.parent_layout);
		mTitleLayout = (RelativeLayout) mView.findViewById(R.id.title_layout);
		mContentLayout = (RelativeLayout) mView.findViewById(R.id.content_layout);
		mBtnLayout = (RelativeLayout) mView.findViewById(R.id.btn_layout);
		mTitle = (TextView) mView.findViewById(R.id.title);
		mTip = (TextView) mView.findViewById(R.id.tip_text);
		mContent = (EditText) mView.findViewById(R.id.content);
		mLeftBtn = (Button) mView.findViewById(R.id.left_btn);
		mRightBtn = (Button) mView.findViewById(R.id.right_btn);
		
		this.setOnShowListener(new OnShowListener() {
			@SuppressLint("NewApi")
			@Override
			public void onShow(DialogInterface dialog) {
				AnimatorSet mAnimatorSet = new AnimatorSet();
				mAnimatorSet.playTogether(ObjectAnimator.ofFloat(mMianLayout, "translationX", Tools.width,0).setDuration(300));
				mAnimatorSet.playTogether(ObjectAnimator.ofFloat(mMianLayout, "alpha", 0,1).setDuration(300));
				mAnimatorSet.start();
			}
		});
		
		mLeftBtn.setOnClickListener(this);
		mRightBtn.setOnClickListener(this);
		
		mTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, Tools.width * 40 / 720);
		mTip.setTextSize(TypedValue.COMPLEX_UNIT_PX, Tools.width * 35 / 720);
		mLeftBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, Tools.width * 30 / 720);
		mRightBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, Tools.width * 30 / 720);
		Tools.setViewWidth(mParentLayout, Tools.width * 3/4);
		Tools.setViewWidth(mContent, Tools.width * 2/3);
		Tools.setViewHeight(mContentLayout, Tools.height * 250 / 1280);
		Tools.setViewHeight(mLeftBtn, Tools.height * 60 / 1280);
		Tools.setViewHeight(mRightBtn, Tools.height * 60 / 1280);
		Tools.setViewWidth(mLeftBtn, Tools.width * 150 / 720);
		Tools.setViewWidth(mRightBtn, Tools.width * 150 / 720);
		Tools.setViewMargin(mTitle, Tools.width * 15 / 720, Tools.height * 10 / 1280, 0, Tools.height * 10 / 1280);
	}
	
	public NiftyDialogBuilder withTitle(CharSequence title){
		mTitle.setText(title);
		return this;
	}
	
	public NiftyDialogBuilder withLeftText(CharSequence text){
		mLeftBtn.setText(text);
		return this; 
	}
	
	public NiftyDialogBuilder withRightText(CharSequence text){
		mRightBtn.setText(text);
		return this; 
	}
	
	/**
	 * 
	 * @param visible VISIBLE 0, INVISIBLE 4 ,GONE 8
	 * @return
	 */
	public NiftyDialogBuilder withTipVisible(int visible){
		mTip.setVisibility(View.VISIBLE);
		return this;
	}
	
	public NiftyDialogBuilder withContentVisible(int visible){
		mContent.setVisibility(visible);
		return this;
	}
	
	
	
	@Override
	public void show() {
		super.show();
	}
	
	@Override
	public void dismiss() {
		super.dismiss();
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_btn:
			break;
		}
		AnimatorSet mAnimatorSet = new AnimatorSet();
		mAnimatorSet.playTogether(ObjectAnimator.ofFloat(mMianLayout, "translationX", 0,Tools.width * -1).setDuration(300));
		mAnimatorSet.playTogether(ObjectAnimator.ofFloat(mMianLayout, "alpha", 1,0).setDuration(300));
		mAnimatorSet.start();
		mAnimatorSet.addListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO Auto-generated method stub
				dismiss();
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub
			}
		});
	}
}
