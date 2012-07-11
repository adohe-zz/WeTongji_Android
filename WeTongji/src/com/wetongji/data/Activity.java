package com.wetongji.data;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Activity {
	
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
	int Favourite;			//收藏计数器
	@DatabaseField
	int Like;				//+1计数器
	@DatabaseField
	int Schedule;			//添加到日程计数器
	@DatabaseField
	boolean CanFavourite;	//是否可以收藏
	@DatabaseField
	boolean CanLike;		//是否可以+1
	@DatabaseField
	boolean CanSchedule;	//是否可以添加到日程
	@DatabaseField
	int Channel_Id;
	@DatabaseField
	String Organizer;
	@DatabaseField
	String Status;
	@DatabaseField
	String Description;
	
	
	
	/**
	 * 
	 */
	public Activity() {
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



	public int getFavourite() {
		return Favourite;
	}



	public void setFavourite(int favourite) {
		Favourite = favourite;
	}



	public int getLike() {
		return Like;
	}



	public void setLike(int like) {
		Like = like;
	}



	public int getSchedule() {
		return Schedule;
	}



	public void setSchedule(int schedule) {
		Schedule = schedule;
	}



	public boolean isCanFavourite() {
		return CanFavourite;
	}



	public void setCanFavourite(boolean canFavourite) {
		CanFavourite = canFavourite;
	}



	public boolean isCanLike() {
		return CanLike;
	}



	public void setCanLike(boolean canLike) {
		CanLike = canLike;
	}



	public boolean isCanSchedule() {
		return CanSchedule;
	}



	public void setCanSchedule(boolean canSchedule) {
		CanSchedule = canSchedule;
	}



	public int getChannel_Id() {
		return Channel_Id;
	}



	public void setChannel_Id(int channel_Id) {
		Channel_Id = channel_Id;
	}



	public String getOrganizer() {
		return Organizer;
	}



	public void setOrganizer(String organizer) {
		Organizer = organizer;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	
}
