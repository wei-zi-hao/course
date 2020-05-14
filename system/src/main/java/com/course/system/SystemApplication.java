package com.course.system;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author eric
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.course.system.mapper")
public class SystemApplication {
	private static final Logger log = LoggerFactory.getLogger(SystemApplication.class);
	public static void main(String[] args) {
		ConfigurableEnvironment evn = SpringApplication.run(SystemApplication.class, args).getEnvironment();
		log.info("System启动成功！");
		log.info("http://127.0.0.1:{}",evn.getProperty("server.port"));
	}

}
