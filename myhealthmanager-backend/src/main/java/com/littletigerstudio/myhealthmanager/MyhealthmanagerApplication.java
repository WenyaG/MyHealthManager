package com.littletigerstudio.myhealthmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.littletigerstudio.myhealthmanager.dao")
@SpringBootApplication
public class MyhealthmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyhealthmanagerApplication.class, args);
	}

}
