package springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import util.SwaggerUtil;

@Configuration
public class SwaggerConfig {

    @Bean
    Docket testDocket() {
		
		return SwaggerUtil.createDocket("Test", testApiInfo(), "springboot.controller");
	}

	private ApiInfo testApiInfo() {
		
		return new ApiInfoBuilder()
				.title("Test Controller")
				.description("test")
				.version("1.0")
				.build();
	}
}
