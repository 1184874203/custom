package com.custom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 11848
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurationSupport {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/news/**").addResourceLocations("file:D:/news-test/static/");
		super.addResourceHandlers(registry);
	}

}
