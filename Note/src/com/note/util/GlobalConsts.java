package com.note.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GlobalConsts {
	public static String[] SORTS = {"日常提醒" , "感想" , "学习" , "工作"};
	public static String[] SORTS_TABLE_NAME = {"remind","feeling","for_study","for_work"};
	public static String TABLE_INFO_NAME = "table_info";
	public static String CREATE_TABLE_INFO_TABEL = "create table if not exists " + TABLE_INFO_NAME +"(id integer primary key autoincrement,table_name varchar,title varchar)";
	
	public static ArrayList<TitleInfo> TITLES = new ArrayList<TitleInfo>();
	
	public static String getDateStr(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date(System.currentTimeMillis());
		return dateFormat.format(currentDate);
	}
}
