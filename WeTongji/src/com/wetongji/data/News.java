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
	News() {
	}
	
}
