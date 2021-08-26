package com.grupo116.moxibackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MoxiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoxiBackendApplication.class, args);
	}

}
