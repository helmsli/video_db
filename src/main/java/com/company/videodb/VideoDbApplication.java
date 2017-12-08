
package com.company.videodb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@MapperScan({ "com.company.videodb.mapper", "com.company.userOrder.mapper" })
@ComponentScan("com.company.videodb,com.company.userOrder")
public class VideoDbApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(VideoDbApplication.class, args);
	}
	catch(Exception e)
	{
		
	}
	}
}
