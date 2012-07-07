package com.wetongji.data;

import com.j256.ormlite.field.DatabaseField;

public class User {
	
	@DatabaseField(id=true)
	String NO;
	@DatabaseField
	String Name;
	@DatabaseField
	String Avatar;
	@DatabaseField
	String UID;
	@DatabaseField
	String Phone;
	@DatabaseField
	String DisplayName;
	@DatabaseField
	String Major;
	@DatabaseField
	String NativePlace;
	@DatabaseField
	String Degree;
	@DatabaseField
	String Gender;
	@DatabaseField
	String Year;	//入学年份
	@DatabaseField
	String Birthday;
	@DatabaseField
	String Plan;	//学制
	@DatabaseField
	String SinaWeibo;
	@DatabaseField
	String QQ;
	@DatabaseField
	String Department;
	@DatabaseField
	String Email;
	
	

	/**
	 * 
	 */
	public User() {
	}



	/**
	 * @param nO
	 * @param name
	 * @param avatar
	 * @param uID
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
	 * @param qQ
	 * @param department
	 * @param email
	 */
	User(String nO, String name, String avatar, String uID, String phone,
			String displayName, String major, String nativePlace,
			String degree, String gender, String year, String birthday,
			String plan, String sinaWeibo, String qQ, String department,
			String email) {
		NO = nO;
		Name = name;
		Avatar = avatar;
		UID = uID;
		Phone = phone;
		DisplayName = displayName;
		Major = major;
		NativePlace = nativePlace;
		Degree = degree;
		Gender = gender;
		Year = year;
		Birthday = birthday;
		Plan = plan;
		SinaWeibo = sinaWeibo;
		QQ = qQ;
		Department = department;
		Email = email;
	}

}
