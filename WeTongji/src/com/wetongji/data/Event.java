package com.wetongji.data;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Event {
	
	@DatabaseField(id=true)
	int Id;
	@DatabaseField
	Date Begin;
	@DatabaseField
	Date End;
	@DatabaseField
	String Title;
	@DatabaseField
	String Location;
	@DatabaseField
	String Description;
	
	
	
	/**
	 * 
	 */
	public Event() {
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public Date getBegin() {
		return Begin;
	}



	public void setBegin(Date begin) {
		Begin = begin;
	}



	public Date getEnd() {
		return End;
	}



	public void setEnd(Date end) {
		End = end;
	}



	public String getTitle() {
		return Title;
	}



	public void setTitle(String title) {
		Title = title;
	}



	public String getLocation() {
		return Location;
	}



	public void setLocation(String location) {
		Location = location;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	
}
