package br.com.danielbgg.tech.spring.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SchedulerApplication.class);
	}
}
