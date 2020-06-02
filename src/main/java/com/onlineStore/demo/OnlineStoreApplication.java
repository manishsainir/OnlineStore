package com.onlineStore.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class OnlineStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreApplication.class, args);
	}

}
