package com.company.videodb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan ("com.company.videodb")
@MapperScan ("com.company.videodb.mapper")
//@ImportResource ({ "classpath:hessian/hessian-client.xml", "classpath:hessian/hessian-server.xml" })
public class VideoDbApplication {

	public static void main(String[] args) {
		try {
		SpringApplication.run(VideoDbApplication.class, args);
		}
		catch(Throwable e)
		{
		   e.printStackTrace();	
		}
	}
}
