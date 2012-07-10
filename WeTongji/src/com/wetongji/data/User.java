package com.wetongji.data;

import com.j256.ormlite.field.DatabaseField;

public class User {
	
	@DatabaseField(id=true)
	private
	String NO;
	@DatabaseField
	private
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
	private
	String NativePlace;
	@DatabaseField
	private
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
	private
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
		setNO(nO);
		setName(name);
		Avatar = avatar;
		UID = uID;
		Phone = phone;
		DisplayName = displayName;
		Major = major;
		setNativePlace(nativePlace);
		setDegree(degree);
		Gender = gender;
		Year = year;
		Birthday = birthday;
		Plan = plan;
		setSinaWeibo(sinaWeibo);
		QQ = qQ;
		Department = department;
		Email = email;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getSinaWeibo() {
		return SinaWeibo;
	}



	public void setSinaWeibo(String sinaWeibo) {
		SinaWeibo = sinaWeibo;
	}



	String getNO() {
		return NO;
	}



	void setNO(String nO) {
		NO = nO;
	}



	public String getNativePlace() {
		return NativePlace;
	}



	public void setNativePlace(String nativePlace) {
		NativePlace = nativePlace;
	}



	public String getDegree() {
		return Degree;
	}



	public void setDegree(String degree) {
		Degree = degree;
	}

}
