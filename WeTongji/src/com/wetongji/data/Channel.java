package com.wetongji.data;

import com.j256.ormlite.field.DatabaseField;

public class Channel {
	
	@DatabaseField(id=true)
	int Id;
	@DatabaseField
	String Title;
	@DatabaseField
	String Image;
	@DatabaseField
	int Follow;
	@DatabaseField
	String Description;
	
	
	
	/**
	 * 
	 */
	public Channel() {
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getTitle() {
		return Title;
	}



	public void setTitle(String title) {
		Title = title;
	}



	public String getImage() {
		return Image;
	}



	public void setImage(String image) {
		Image = image;
	}



	public int getFollow() {
		return Follow;
	}



	public void setFollow(int follow) {
		Follow = follow;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	
}
