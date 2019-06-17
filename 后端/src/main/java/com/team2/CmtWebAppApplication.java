package com.team2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类 
 */ 
@SpringBootApplication
//扫描接口类，这个配置只能扫描该包下的接口，不能扫描mapper文件
@MapperScan(basePackages="com.team2.dao")
@EnableTransactionManagement
@EnableScheduling
@EnableSwagger2
public class CmtWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmtWebAppApplication.class, args);
	}
}
