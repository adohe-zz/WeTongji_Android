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
	public User() {
	}



	/**
	 * @param no
	 * @param name
	 * @param avatar
	 * @param uid
	 * @param phone
	 * @param displayName
	 * @param major
	 * @param nativePlace
	 * @param degree
	 * @param gender
	 * @param year
	 * @param birthday
	 * @param plan
	 * @param sinaWeibo
	 * @param qq
	 * @param department
	 * @param email
	 */
	public User(String no, String name, String avatar, String uid, String phone,
			String displayName, String major, String nativePlace,
			String degree, String gender, String year, String birthday,
			String plan, String sinaWeibo, String qq, String department,
			String email) {
		this.no = no;
		this.name = name;
		this.avatar = avatar;
		this.uid = uid;
		this.phone = phone;
		this.displayName = displayName;
		this.major = major;
		this.nativePlace = nativePlace;
		this.degree = degree;
		this.gender = gender;
		this.year = year;
		this.birthday = birthday;
		this.plan = plan;
		this.sinaWeibo = sinaWeibo;
		this.qq = qq;
		this.department = department;
		this.email = email;
	}

}
