package com.Kawul.BookStoreApp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.Kawul.BookStoreApp")
@SpringBootApplication
//exclude表示自动配置时不包括Multipart配置
@MapperScan(basePackages = "com.Kawul.BookStoreApp.repository")// mybatis 需要扫描mapper接口, 记得加上
//@AutoConfigurationPackage(basePackages = {MultipartAutoConfiguration.class})
public class BookStoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreAppApplication.class, args);
	}

}
