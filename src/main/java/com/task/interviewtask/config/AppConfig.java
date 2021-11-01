package com.task.interviewtask.config;

import com.github.javafaker.Faker;
import com.task.interviewtask.logic.FakeDataGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = FakeDataGenerator.class)
public class AppConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public FakeDataGenerator fakeDataGenerator() {
        return new FakeDataGenerator();
    }
}
