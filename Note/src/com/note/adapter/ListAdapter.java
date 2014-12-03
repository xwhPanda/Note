package com.note.adapter;

import java.util.ArrayList;

import com.note.activity.R;
import com.note.util.GlobalConsts;
import com.note.util.ItemView;
import com.note.util.NiftyDialogBuilder;
import com.note.util.TitleInfo;
import com.note.util.Tools;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private ArrayList<TitleInfo> titles;
	private Context context;
	private Holder holder;
	private float x;
	private float y;
	
	public ListAdapter(Context context , ArrayList<TitleInfo> titels){
		mInflater = LayoutInflater.from(context);
		this.context = context;
		this.titles = titels;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return titles.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return titles.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		holder = null;
		ItemView itemView = (ItemView) convertView;
		if (itemView == null) {
			holder = new Holder();
			itemView = new ItemView(context);
			
			holder.left_layout = (RelativeLayout) itemView.findViewById(R.id.left_layout);
			holder.title = (TextView) itemView.findViewById(R.id.title);
			holder.count = (TextView) itemView.findViewById(R.id.count);
			holder.create_time = (TextView) itemView.findViewById(R.id.create_date);
			holder.modify_time = (TextView) itemView.findViewById(R.id.modify_date);
			holder.delete = (Button) itemView.findViewById(R.id.delete);
			holder.scroll_view = (LinearLayout) itemView.findViewById(R.id.scroll_view);
			
			Tools.setViewWidth(holder.left_layout, Tools.width);
			itemView.setTag(holder);
		}else {
			holder = (Holder) itemView.getTag();
		}
		
		holder.title.setText(titles.get(position).getTitle());
		holder.count.setText(titles.get(position).getCount() + "");
		holder.create_time.setText(titles.get(position).getCreate_date());
		holder.modify_time.setText(titles.get(position).getModify_date());
		
		holder.delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new NiftyDialogBuilder(context, R.style.MyDialogTheme)
				.withType(GlobalConsts.SAVE_NOTE)
				.withTitle("提示")
				.withContentVisible(View.GONE)
				.withTipVisible(View.VISIBLE)
				.withTip(context.getResources().getString(R.string.delete_tip))
				.show();
			}
		});
		
		return itemView;
	}
	
	class Holder{
		RelativeLayout left_layout;
		TextView title;
		TextView count;
		TextView create_time;
		TextView modify_time;
		Button delete;
		LinearLayout scroll_view;
	}
}
