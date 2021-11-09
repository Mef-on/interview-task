package com.task.interviewtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class InterviewTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(InterviewTaskApplication.class, args);
	}
}
