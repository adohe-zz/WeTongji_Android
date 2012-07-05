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
	public Channel() {
	}



	/**
	 * @param id
	 * @param title
	 * @param image
	 * @param follow
	 * @param description
	 */
	public Channel(int id, String title, String image, int follow, String description) {
		this.id = id;
		this.title = title;
		this.image = image;
		this.follow = follow;
		this.description = description;
	}
	
}
