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
	CommandLineRunner runner(BookRepository bookRepository) {
		return args -> {
			Book bk = new Book(2, "Harry Potter", 5);
			Book bk1 = new Book(3, "Steal like an Artist", 4);
			Book bk2 = new Book(4, "The Power", 5);
			Book bk3 = new Book(5, "Bhagwat Gita", 4);
			log.info("Book=" + bk);
			bookRepository.createBook(bk);
			bookRepository.createBook(bk1);
			bookRepository.createBook(bk2);
			bookRepository.createBook(bk3);
		};
	}

}
