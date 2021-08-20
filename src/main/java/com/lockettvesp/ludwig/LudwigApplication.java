package com.lockettvesp.ludwig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class LudwigApplication {

	public static void main(String[] args) {
		log.info("Starting Ludwig Application" );
		SpringApplication.run(LudwigApplication.class, args);
	}

}
