package com.company.Customer. security;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	   registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", 
	"PATCH");
	  }
}
