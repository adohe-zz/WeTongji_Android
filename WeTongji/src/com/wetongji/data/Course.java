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
	public Course() {
	}



	/**
	 * @param no
	 * @param hours
	 * @param point
	 * @param name
	 * @param teacher
	 * @param weekType
	 * @param weekDay
	 * @param sectionStart
	 * @param sectionEnd
	 * @param required
	 * @param location
	 */
	public Course(String no, int hours, float point, String name, String teacher,
			String weekType, String weekDay, int sectionStart, int sectionEnd,
			String required, String location) {
		this.no = no;
		this.hours = hours;
		this.point = point;
		this.name = name;
		this.teacher = teacher;
		this.weekType = weekType;
		this.weekDay = weekDay;
		this.sectionStart = sectionStart;
		this.sectionEnd = sectionEnd;
		this.required = required;
		this.location = location;
	}
	
}
