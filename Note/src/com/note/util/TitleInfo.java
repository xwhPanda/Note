package com.note.util;

import android.content.Context;

public class TitleInfo {
	private int id;
	private String table_name;
	private String title;
	private String string;
	private int count;
	private String create_date;
	private String modify_date;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getString(){
		return id + "=" + table_name + "=" + title + "=" + count + "=" + create_date + "=" + modify_date;
	} 
}
