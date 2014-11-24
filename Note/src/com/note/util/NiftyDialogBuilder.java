package com.note.util;

import com.note.activity.R;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NiftyDialogBuilder extends Dialog implements DialogInterface{
	private View mView;
	private RelativeLayout mMianLayout;
	private LinearLayout mParentLayout;
	private RelativeLayout mTitleLayout;
	private RelativeLayout mContentLayout;
	private RelativeLayout mBtnLayout;
	private TextView mTitle;
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

	private void initView(Context context){
		mView = View.inflate(context, R.layout.dialog_layout, null);
		setContentView(mView);
		mMianLayout = (RelativeLayout) mView.findViewById(R.id.main_layout);
		mParentLayout = (LinearLayout) mView.findViewById(R.id.parent_layout);
		mTitleLayout = (RelativeLayout) mView.findViewById(R.id.title_layout);
		mContentLayout = (RelativeLayout) mView.findViewById(R.id.content_layout);
		mBtnLayout = (RelativeLayout) mView.findViewById(R.id.btn_layout);
		mTitle = (TextView) mView.findViewById(R.id.title);
		mContent = (EditText) mView.findViewById(R.id.content);
		mLeftBtn = (Button) mView.findViewById(R.id.left_btn);
		mRightBtn = (Button) mView.findViewById(R.id.right_btn);
		
		this.setOnShowListener(new OnShowListener() {
			
			@Override
			public void onShow(DialogInterface dialog) {
			}
		});
		
		mTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, Tools.width * 40 / 720);
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
	
	
	
	@Override
	public void show() {
		super.show();
	}
	
	@Override
	public void dismiss() {
		super.dismiss();
	}
}
