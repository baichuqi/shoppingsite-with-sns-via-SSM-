package com.bai.springboot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.bai.springboot.util.DateUtil;

public class Text implements Serializable{
	 	private String userName;
	    private String message;
	    private String emitTime = DateUtil.now();
	    private String color = "#2E2E2E";
	    private String bubbleColor = "#CECECE";
	    private String fontSize = "12";
	    private String fontType = "黑体";
	    private String send;
	    private String from;
	    private Date time;
	    
	    
	    
	    
	    public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public void setSend(String send) {	    	
	    	this.send =send;
	    }
	    
	    public String getSend() {
	    	return send;
	    }
	    
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getEmitTime() {
			return emitTime;
		}
		public void setEmitTime(String emitTime) {
			this.emitTime = emitTime;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getBubbleColor() {
			return bubbleColor;
		}
		public void setBubbleColor(String bubbleColor) {
			this.bubbleColor = bubbleColor;
		}
		public String getFontSize() {
			return fontSize;
		}
		public void setFontSize(String fontSize) {
			this.fontSize = fontSize;
		}
		public String getFontType() {
			return fontType;
		}
		public void setFontType(String fontType) {
			this.fontType = fontType;
		}
	    
	    
}
