package com.bai.springboot.service;

import java.util.List;

public interface IBaseService<T> {

	Integer save(T t);
	
	void delete(String id);
	
	T findById (String id);
	
	void update (T t);
	
	List<T> list();
	
}
