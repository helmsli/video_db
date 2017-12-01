package com.company.videodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
    	/*
    	return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.videodb.controller.rest"))
                .paths(PathSelectors.any())
                .build();
        */
    	return new Docket(DocumentationType.SWAGGER_2)
		           .apiInfo(apiInfo()).select()
		           .apis(RequestHandlerSelectors.basePackage("com.company"))
		           .paths(PathSelectors.any())
		           .build();
    	    }

    private ApiInfo apiInfo() {
    	Contact contact = new Contact("timebusker", "timebusker@vip.qq.com", "576697722");
		return new ApiInfoBuilder()
		           .title("Spring Boot中使用Swagger2构建RESTful APIs")
		           .description("更多Spring Boot相关实践请关注：https://github.com/timebusker/spring-boot")
		           .termsOfServiceUrl("https://github.com/timebusker/spring-boot/tree/master/spring-boot-12-Swagger2/")
		           .contact(contact)
		           .version("2.0.0")
		           .build();
    }

}
