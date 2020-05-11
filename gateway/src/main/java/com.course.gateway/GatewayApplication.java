package com.course.gateway;

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
public class GatewayApplication {
	private static final Logger log = LoggerFactory.getLogger(GatewayApplication.class);
	public static void main(String[] args) {
		ConfigurableEnvironment evn = SpringApplication.run(GatewayApplication.class, args).getEnvironment();
		log.info("Gateway启动成功！");
		log.info("http://127.0.0.1:{}",evn.getProperty("server.port"));
	}

}
