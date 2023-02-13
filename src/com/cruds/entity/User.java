package com.cruds.entity;

public class User {
	
	private String userId;
	private String pwd;
	private String role;
	
	public User(String userId, String role) {
		super();
		this.userId = userId;
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", role=" + role + "]";
	}
	
	
}
