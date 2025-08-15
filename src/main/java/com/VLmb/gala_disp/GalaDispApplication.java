package com.VLmb.gala_disp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GalaDispApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalaDispApplication.class, args);
	}

}
