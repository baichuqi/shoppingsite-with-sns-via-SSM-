package com.bai.springboot.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.bai.springboot.util.DateUtil;

public class MessageBean {
	
	//private int id;
	private String detail;
	private String mfrom;
	private String mto;
	private LocalDateTime mtime=LocalDateTime.now();
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getMfrom() {
		return mfrom;
	}
	public void setMfrom(String mfrom) {
		this.mfrom = mfrom;
	}
	public String getMto() {
		return mto;
	}
	public void setMto(String mto) {
		this.mto = mto;
	}
	public LocalDateTime getMtime() {
		return mtime;
	}
	public void setMtime(LocalDateTime mtime) {
		this.mtime = mtime;
	}
	
	
}
