package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

		WelcomeMessage welcomeMessage = applicationContext.getBean(WelcomeMessage.class);
		System.out.println(welcomeMessage.getWelcomeMessage());

	}

}
