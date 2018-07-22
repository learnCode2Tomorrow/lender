package com.lender;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan("com.lyz.lender.dao")
public class LenderApplication //extends SpringBootServletInitializer
{
	public static void main(String[] args)
	{
		SpringApplication.run(LenderApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
//	{
//		return application.sources(LenderApplication.class);
//	}

}
