package com.bai.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class DefualtView extends WebMvcConfigurerAdapter{

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/shop").setViewName("forward:shop.html");
		registry.addViewController("/shopping").setViewName("forward:index.html");
		registry.addViewController("/text").setViewName("forward:text.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
	}
}
