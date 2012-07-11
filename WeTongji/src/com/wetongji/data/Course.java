package com.wetongji.data;

import com.j256.ormlite.field.DatabaseField;

public class Course {
	
	@DatabaseField(id=true)
	String NO;
	@DatabaseField
	int Hours;
	@DatabaseField
	float Point;
	@DatabaseField
	String Name;
	@DatabaseField
	String Teacher;
	@DatabaseField
	String WeekType;
	@DatabaseField
	String WeekDay;
	@DatabaseField
	int SectionStart;
	@DatabaseField
	int SectionEnd;
	@DatabaseField
	String Required;
	@DatabaseField
	String Location;
	
	
	
	/**
	 * 
	 */
	public Course() {
	}



	public String getNO() {
		return NO;
	}



	public void setNO(String nO) {
		NO = nO;
	}



	public int getHours() {
		return Hours;
	}



	public void setHours(int hours) {
		Hours = hours;
	}



	public float getPoint() {
		return Point;
	}



	public void setPoint(float point) {
		Point = point;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getTeacher() {
		return Teacher;
	}



	public void setTeacher(String teacher) {
		Teacher = teacher;
	}



	public String getWeekType() {
		return WeekType;
	}



	public void setWeekType(String weekType) {
		WeekType = weekType;
	}



	public String getWeekDay() {
		return WeekDay;
	}



	public void setWeekDay(String weekDay) {
		WeekDay = weekDay;
	}



	public int getSectionStart() {
		return SectionStart;
	}



	public void setSectionStart(int sectionStart) {
		SectionStart = sectionStart;
	}



	public int getSectionEnd() {
		return SectionEnd;
	}



	public void setSectionEnd(int sectionEnd) {
		SectionEnd = sectionEnd;
	}



	public String getRequired() {
		return Required;
	}



	public void setRequired(String required) {
		Required = required;
	}



	public String getLocation() {
		return Location;
	}



	public void setLocation(String location) {
		Location = location;
	}



	
}
