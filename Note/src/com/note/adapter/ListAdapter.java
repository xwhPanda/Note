package com.note.adapter;

import java.util.ArrayList;

import com.note.activity.R;
import com.note.util.TitleInfo;
import com.note.util.Tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private ArrayList<TitleInfo> titles;
	private Context context;
	
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
		Holder holder = null;
		if (convertView == null) {
			holder = new Holder();
			convertView = mInflater.inflate(R.layout.list_adapter_item, parent,false);
			
			holder.left_layout = (RelativeLayout) convertView.findViewById(R.id.left_layout);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.count = (TextView) convertView.findViewById(R.id.count);
			holder.create_time = (TextView) convertView.findViewById(R.id.create_date);
			holder.modify_time = (TextView) convertView.findViewById(R.id.modify_date);
			
			Tools.setViewWidth(holder.left_layout, Tools.width);
			convertView.setTag(holder);
		}else {
			holder = (Holder) convertView.getTag();
		}
		
		holder.title.setText(titles.get(position).getTitle());
		holder.count.setText(titles.get(position).getCount() + "");
		holder.create_time.setText(titles.get(position).getCreate_date());
		holder.modify_time.setText(titles.get(position).getModify_date());
		return convertView;
	}
	
	class Holder{
		RelativeLayout left_layout;
		TextView title;
		TextView count;
		TextView create_time;
		TextView modify_time;
	}

}
