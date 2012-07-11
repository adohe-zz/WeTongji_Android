package com.wetongji.data;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class News {
	
	@DatabaseField(id=true)
	int Id;
	@DatabaseField
	String Title;
	@DatabaseField
	String Context;
	@DatabaseField
	int Read;
	@DatabaseField
	String Category;
	@DatabaseField
	Date CreatedAt;
	
	
	
	/**
	 * 
	 */
	public News() {
	}



	public void setId(int id) {
		Id = id;
	}



	public void setTitle(String title) {
		Title = title;
	}



	public void setContext(String context) {
		Context = context;
	}



	public void setRead(int read) {
		Read = read;
	}



	public void setCategory(String category) {
		Category = category;
	}



	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}



	public int getId() {
		return Id;
	}



	public String getTitle() {
		return Title;
	}



	public String getContext() {
		return Context;
	}



	public int getRead() {
		return Read;
	}



	public String getCategory() {
		return Category;
	}



	public Date getCreatedAt() {
		return CreatedAt;
	}



	
	
}
