package com.ssafy.trip.config;

import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import listener.AppInitListener;

@Configuration
public class WebConfig implements WebMvcConfigurer  {
	
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> appInitListener() {
	    ServletListenerRegistrationBean<ServletContextListener> srb
	        = new ServletListenerRegistrationBean<>();

	    srb.setListener(new AppInitListener());
	    return srb;
	}

}
