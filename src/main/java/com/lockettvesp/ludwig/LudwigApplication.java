package com.lockettvesp.ludwig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lockettvesp.ludwig.data.CommandRepository;
import com.lockettvesp.ludwig.model.Command;
import com.lockettvesp.ludwig.model.CommandType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class LudwigApplication {
	public static void main(String[] args) {
		log.info("Starting Application" );
		SpringApplication.run(LudwigApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(CommandRepository repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Command("Directories", CommandType.DIR));
				repo.save(new Command("Anti-Malware Scan Interfaces", CommandType.AMSI_PROVIDERS));
				repo.save(new Command("Operating System Information", CommandType.OS_INFO));
			}
		};
	}
}
