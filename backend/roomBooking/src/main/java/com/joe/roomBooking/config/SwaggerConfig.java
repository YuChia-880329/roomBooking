package com.joe.roomBooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import util.config.SwaggerConfigUtil;

@Configuration
public class SwaggerConfig {

    @Bean
    Docket testDocket() {
		
		return SwaggerConfigUtil.createDocket("Test", testApiInfo(), "com.joe.roomBooking.controller");
	}

	private ApiInfo testApiInfo() {
		
		return new ApiInfoBuilder()
				.title("Test Controller")
				.description("test")
				.version("1.0")
				.build();
	}
}
