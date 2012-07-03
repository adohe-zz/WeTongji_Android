package com.wetongji.data;

import com.j256.ormlite.field.DatabaseField;

public class Course {
	
	@DatabaseField(id=true)
	String no;
	@DatabaseField
	int hours;
	@DatabaseField
	float point;
	@DatabaseField
	String name;
	@DatabaseField
	String teacher;
	@DatabaseField
	String weekType;
	@DatabaseField
	String weekDay;
	@DatabaseField
	int sectionStart;
	@DatabaseField
	int sectionEnd;
	@DatabaseField
	String required;
	@DatabaseField
	String location;
	
	
	
	/**
	 * 
	 */
	Course() {
	}
	
}
