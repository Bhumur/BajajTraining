package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class WebConfig {
	
	@Bean
	ModelAndView mView() {
		return new ModelAndView();
	}

}
