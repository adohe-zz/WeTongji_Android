package com.wetongji.data;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class News {
	
	@DatabaseField(id=true)
	int id;
	@DatabaseField
	String title;
	@DatabaseField
	String context;
	@DatabaseField
	int read;
	@DatabaseField
	String category;
	@DatabaseField
	Date createdAt;
	
	
	
	/**
	 * 
	 */
	public News() {
	}



	/**
	 * @param id
	 * @param title
	 * @param context
	 * @param read
	 * @param category
	 * @param createdAt
	 */
	public News(int id, String title, String context, int read, String category,
			Date createdAt) {
		this.id = id;
		this.title = title;
		this.context = context;
		this.read = read;
		this.category = category;
		this.createdAt = createdAt;
	}
	
}
