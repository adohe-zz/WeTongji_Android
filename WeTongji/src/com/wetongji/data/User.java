package com.wetongji.data;

import com.j256.ormlite.field.DatabaseField;

public class User {
	
	@DatabaseField(id=true)
	String no;
	@DatabaseField
	String name;
	@DatabaseField
	String avatar;
	@DatabaseField
	String uid;
	@DatabaseField
	String phone;
	@DatabaseField
	String displayName;
	@DatabaseField
	String major;
	@DatabaseField
	String nativePlace;
	@DatabaseField
	String degree;
	@DatabaseField
	String gender;
	@DatabaseField
	String year;	//入学年份
	@DatabaseField
	String birthday;
	@DatabaseField
	String plan;	//学制
	@DatabaseField
	String sinaWeibo;
	@DatabaseField
	String qq;
	@DatabaseField
	String department;
	@DatabaseField
	String email;
	
	

	/**
	 * 
	 */
	User() {
	}

}
