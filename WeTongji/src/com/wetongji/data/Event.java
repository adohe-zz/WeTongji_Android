package com.wetongji.data;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Event {
	
	@DatabaseField(id=true)
	int id;
	@DatabaseField
	Date begin;
	@DatabaseField
	Date end;
	@DatabaseField
	String title;
	@DatabaseField
	String location;
	@DatabaseField
	String description;
	
	
	
	/**
	 * 
	 */
	public Event() {
	}



	/**
	 * @param id
	 * @param begin
	 * @param end
	 * @param title
	 * @param location
	 * @param description
	 */
	public Event(int id, Date begin, Date end, String title, String location,
			String description) {
		this.id = id;
		this.begin = begin;
		this.end = end;
		this.title = title;
		this.location = location;
		this.description = description;
	}
	
}
