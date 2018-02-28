package com.demo;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringBootMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDemoApplication.class, args);
	}
	
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("boot-demo")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/demo/.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("REST APIs")
				.description("REST APIs")
				.termsOfServiceUrl("http://....")
				.license("MyCompany Licensed")
				.licenseUrl("https://mycompany.com")
				.version("2.0").build();
	}
}
