package com.ken.entity;

public class User implements java.io.Serializable {
	
	public User(){}
	public User(int id,String userName,String sex){
		this.id = id;
		this.userName = userName;
		this.sex = sex;
	}
	
	private int id;
	private String userName;
	private String sex;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

}
