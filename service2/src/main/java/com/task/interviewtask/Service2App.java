package com.task.interviewtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Service2App {

    public static void main(String[] args) {
        SpringApplication.run(Service2App.class, args);
    }
//
//    public static void main(String[] args) throws IOException {
//
//        ConfigurableApplicationContext context = SpringApplication.run(Service2App.class, args);
//        GraphQLService graphQLService = (GraphQLService) context.getBean("graphQLService");
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        ClientDTO countryDto = graphQLService.getCountryDetails("name");
//        log.info(ow.writeValueAsString(countryDto));
}

