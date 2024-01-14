package com.POJO;

public class Student {
	private int user_id;
	private String usename;
	private String password;
	private String phone;
	private String email;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getusename() {
		return usename;
	}

	public void setusename(String usename) {
		this.usename = usename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student(int user_id, String usename, String password, String phone, String email) {
		super();
		this.user_id = user_id;
		this.usename = usename;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	public Student(String usename, String password, String phone, String email) {
		super();
		this.usename = usename;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [" + user_id + "," + usename + "," + password + "," + phone + "," + email + ","  + "]";
		 
	}

}
