package com.task.interviewtask.config;

import com.github.javafaker.Faker;
import com.task.interviewtask.api.FakeDataApi;
import com.task.interviewtask.logic.FakeDataGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public FakeDataGenerator fakeDataGenerator(Faker faker) {
        return new FakeDataGenerator(faker);
    }

    @Bean
    public FakeDataApi fakeDataApi(FakeDataGenerator fakeDataGenerator) {
        return new FakeDataApi(fakeDataGenerator);
    }
}
