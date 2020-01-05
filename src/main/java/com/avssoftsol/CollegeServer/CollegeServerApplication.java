package com.avssoftsol.CollegeServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CollegeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeServerApplication.class, args);
	}

}
