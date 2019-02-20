package com.bai.springboot.entity;

public class Product {
	
	private String productId;
	private int productCode;
	private String productName;
	private Double price;
	private int categoryId;
	private String sellerId;
	private String brief;
	private String detail;
	
	
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getId() {
		return productId;
	}
	public void setId(String id) {
		this.productId = id;
	}
	public int getCode() {
		return productCode;
	}
	public void setCode(int code) {
		this.productCode = code;
	}
	public String getName() {
		return productName;
	}
	public void setName(String name) {
		this.productName = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
