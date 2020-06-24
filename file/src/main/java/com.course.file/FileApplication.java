package com.course.file;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author eric
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.course")
@MapperScan("com.course.server.mapper")
public class FileApplication {
	private static final Logger log = LoggerFactory.getLogger(FileApplication.class);
	public static void main(String[] args) {
		ConfigurableEnvironment evn = SpringApplication.run(FileApplication.class, args).getEnvironment();
		log.info("File启动成功！");
		log.info("http://127.0.0.1:{}",evn.getProperty("server.port"));
	}

}
