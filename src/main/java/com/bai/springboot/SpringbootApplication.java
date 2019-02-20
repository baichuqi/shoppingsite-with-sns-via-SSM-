package com.bai.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan(basePackages = {"com.bai.springboot.dao"})
public class SpringbootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringbootApplication.class, args);

	}

}
