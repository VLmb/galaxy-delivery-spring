package com.VLmb.gala_contr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@SpringBootApplication
public class GalaContrApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalaContrApplication.class, args);
	}

	@Bean
	public WebClient dispatcherWebClient() {
		return WebClient.create("http://localhost:8081");
	}


}
