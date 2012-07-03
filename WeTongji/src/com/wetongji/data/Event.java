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
	Event() {
	}
	
}
