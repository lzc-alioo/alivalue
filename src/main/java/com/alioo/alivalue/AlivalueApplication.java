package com.alioo.alivalue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AlivalueApplication {
	private static Logger logger = LoggerFactory.getLogger(AlivalueApplication.class);


	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(AlivalueApplication.class, args);

		AppConfig appConfig=context.getBean(AppConfig.class);


		logger.info("come here"+appConfig.toString());




	}

}
