package com.wetongji.data;

import com.j256.ormlite.field.DatabaseField;

public class Channel {
	
	@DatabaseField(id=true)
	int id;
	@DatabaseField
	String title;
	@DatabaseField
	String image;
	@DatabaseField
	int follow;
	@DatabaseField
	String description;
	
	
	
	/**
	 * 
	 */
	Channel() {
	}
	
}
