package com.bai.springboot.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@RequestMapping("test/{page}")
	public void geTest(@PathVariable String page){
		
	}
}
