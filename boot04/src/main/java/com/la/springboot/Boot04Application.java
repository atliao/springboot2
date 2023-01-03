package com.la.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@MapperScan("com.la.springboot.mapper")
@ServletComponentScan(basePackages = "com.la.springboot") //指定原生servlet组件的位置
@SpringBootApplication
public class Boot04Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot04Application.class, args);
	}

}
