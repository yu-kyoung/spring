package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.demo.**.mapper" ) //mapper 찾음{"",""}
@SpringBootApplication
public class Exe01Application {

	public static void main(String[] args) {
		SpringApplication.run(Exe01Application.class, args);
	}

}
