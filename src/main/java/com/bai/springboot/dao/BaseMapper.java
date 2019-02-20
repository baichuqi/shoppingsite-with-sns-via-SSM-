package com.bai.springboot.dao;

import java.util.List;

public interface BaseMapper <T> {

	Integer save(T t);
	
	void delete(String id);
	
	T findById(String id);
	
	void update(T t);
	
	List<T> list();
}
