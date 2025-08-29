package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class Ex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex1Application.class, args);
	}

}
