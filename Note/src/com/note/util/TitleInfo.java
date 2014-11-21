package com.note.util;

public class TitleInfo {
	private int id;
	private String table_name;
	private String title;
	private String string;
	
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
		return id + "=" + table_name + "=" + title;
	} 
}
