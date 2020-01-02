package com.accp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.accp.mapper")
public class Java2SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java2SpringbootApplication.class, args);
	}

}
