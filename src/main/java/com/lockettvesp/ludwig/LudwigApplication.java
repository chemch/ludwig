package com.lockettvesp.ludwig;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lockettvesp.ludwig.data.CommandRepository;
import com.lockettvesp.ludwig.data.OperatorRepository;
import com.lockettvesp.ludwig.data.SourceRepository;
import com.lockettvesp.ludwig.model.Command;
import com.lockettvesp.ludwig.model.CommandType;
import com.lockettvesp.ludwig.model.Operator;
import com.lockettvesp.ludwig.model.Source;
import com.lockettvesp.ludwig.model.SourceType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class LudwigApplication {
	public static void main(String[] args) {
		log.info("Starting Application" );
		SpringApplication.run(LudwigApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLoader(CommandRepository repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Command("Directories", CommandType.DIR));
				repo.save(new Command("Anti-Malware Scan Interfaces", CommandType.AMSI_PROVIDERS));
				repo.save(new Command("Operating System Information", CommandType.OS_INFO));
			}
		};		
	}
	
	@Bean
	public CommandLineRunner sourceLoader(SourceRepository repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Source(SourceType.WORKSTATION, "192.168.1.1"));
				repo.save(new Source(SourceType.SERVER, "192.168.1.2"));
			}
		};
	}
	
	@Bean
	public CommandLineRunner operatorLoader(OperatorRepository repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Operator("ghost"));
				repo.save(new Operator("fairy"));
			}
		};
	}
}
