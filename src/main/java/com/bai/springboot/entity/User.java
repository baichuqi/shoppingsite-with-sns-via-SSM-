package com.bai.springboot.entity;

public class User {

	private String id;
	private String fakename;
	private String password;
	private int rightNum;
	private boolean logined;
	private String sessionid;
	
	
	public boolean isLogined() {
		return logined;
	}
	public void setLogined(boolean logined) {
		this.logined = logined;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFakename() {
		return fakename;
	}
	public void setFakename(String fakename) {
		this.fakename = fakename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRightNum() {
		return rightNum;
	}
	public void setRightNum(int rightNum) {
		this.rightNum = rightNum;
	}
	
	
	
}
