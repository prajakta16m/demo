package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

		WelcomeMessage welcomeMessage = applicationContext.getBean(WelcomeMessage.class);
		System.out.println(welcomeMessage.getWelcomeMessage());

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Book run = new Book(34523, "Atomic Habits", 5);
			log.info("Run=" + run);
		};
	}

}
