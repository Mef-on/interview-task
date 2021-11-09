package com.task.interviewtask.logic;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.netflix.graphql.dgs.client.MonoGraphQLClient;
import com.netflix.graphql.dgs.client.WebClientGraphQLClient;
import com.task.interviewtask.model.ClientDTO;
//import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GraphQLService implements GraphQLQueryResolver {

    DataConverter dataConverter;

    public GraphQLService(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    //    public List<ClientDTO> getAllClients(){
//        return null;
//    }
//    DataConverter dataConverter;
//
//    public GraphQLService(DataConverter dataConverter) {
//        this.dataConverter = dataConverter;
//    }
//
    public List<ClientDTO> getAllClients(int size) {

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8080/generate/json/";
        ResponseEntity<ClientDTO[]> response
                = restTemplate.getForEntity(resourceUrl + size, ClientDTO[].class);
        return Arrays.stream(response.getBody()).collect(Collectors.toList());
    }

//    public String getSchema(){
//        //Configure a WebClient for your needs, e.g. including authentication headers and TLS.
//        WebClient webClient = WebClient.create("http://localhost:8081/graphql");
//        WebClientGraphQLClient client = MonoGraphQLClient.createWithWebClient(webClient);
//
////The GraphQLResponse contains data and errors.
//        Mono<GraphQLResponse> graphQLResponseMono = graphQLClient.reactiveExecuteQuery(query);
//
////GraphQLResponse has convenience methods to extract fields using JsonPath.
//        Mono<String> somefield = graphQLResponseMono.map(r -> r.extractValue("somefield"));
//
////Don't forget to subscribe! The request won't be executed otherwise.
//        somefield.subscribe();
//    }
}
