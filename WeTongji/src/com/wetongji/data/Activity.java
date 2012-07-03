package com.wetongji.data;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Activity {
	
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
	int favourite;			//收藏计数器
	@DatabaseField
	int like;				//+1计数器
	@DatabaseField
	int schedule;			//添加到日程计数器
	@DatabaseField
	boolean canFavourite;	//是否可以收藏
	@DatabaseField
	boolean canLike;		//是否可以+1
	@DatabaseField
	boolean canSchedule;	//是否可以添加到日程
	@DatabaseField
	int channel_id;
	@DatabaseField
	String organizer;
	@DatabaseField
	String status;
	@DatabaseField
	String description;
	
	
	
	/**
	 * 
	 */
	Activity() {
	}
	
}
