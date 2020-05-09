package course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author eric
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
	private static final Logger log = LoggerFactory.getLogger(EurekaApplication.class);
	public static void main(String[] args) {
		ConfigurableEnvironment evn = SpringApplication.run(EurekaApplication.class, args).getEnvironment();
		log.info("启动成功！");
		log.info("127.0.0.1:{}",evn.getProperty("server.port"));
	}

}
