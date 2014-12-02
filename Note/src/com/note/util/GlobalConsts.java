package com.note.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.note.activity.R;

public class GlobalConsts {
	public static int[] SORTS = {R.string.feeling , R.string.remind , R.string.for_study , R.string.for_work};
	public static String[] SORTS_TABLE_NAME = {"remind","feeling","for_study","for_work"};
	public static String TABLE_INFO_NAME = "table_info";
	public static String CREATE_TABLE_INFO_TABEL = "create table if not exists " + TABLE_INFO_NAME +"(id integer primary key autoincrement,table_name varchar,title varchar,count int,create_date String,modify_date String)";
	public static int SAVE_SORT = 0;//保存分类
	public static int SAVE_NOTE = 1;//保存笔记
	
	public static ArrayList<TitleInfo> TITLES = new ArrayList<TitleInfo>();
	
	public static String getDateStr(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date(System.currentTimeMillis());
		return dateFormat.format(currentDate);
	}
}