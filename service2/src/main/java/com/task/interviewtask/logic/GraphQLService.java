package com.task.interviewtask.logic;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.task.interviewtask.model.ClientDTO;
import com.task.interviewtask.model.GraphqlRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class GraphQLService implements GraphQLQueryResolver{

    private final String url;

    public GraphQLService(@Value("http://localhost:8081/graphqlp") String url) {
        this.url = url;
    }

    public List<ClientDTO> getAllClients() {
//        String urlDataClients =
        return Arrays.asList(
                ClientDTO.builder()
                        .name("Działa")
                        .distance("lol")
                        .build()
        );
    }

    //    public Flux<ClientDTO> getAllClients(int size) {
//        WebClient webClient = WebClient.builder().build();
//
//        String urlDataClients = "http://localhost:8080/generate/json/" + size;
//        return webClient.get()
//                .uri(urlDataClients)
//                .retrieve()
//                .bodyToFlux(ClientDTO.class);
//    }
//    public ClientDTO getAllClients() {
//        return WebClient.create().get()
//                .uri("http://localhost:8080/generate/json/1")
//                .retrieve()
//                .bodyToMono(ClientDTO.class)
//                .block();
//
//    }

    public ClientDTO getCountryDetails(final String name) throws IOException {

        WebClient webClient = WebClient.builder().build();

        GraphqlRequestBody graphQLRequestBody = new GraphqlRequestBody();

        final String query = GraphqlSchemaReaderUtil.getSchemaFromFileName("getCountryDetails");
//        String query = "{\n" +
//                "  ClientDTO {\n" +
//                "    name\n" +
//                "  }\n" +
//                "}";

//        String variables = "{\n" +
//                "  “name” : “name”\n" +
//                "}";
////        String variables = "{\n" +
////                "  “name” : “name”\n" +
////                "}";
        final String variables = GraphqlSchemaReaderUtil.getSchemaFromFileName("variables");

        graphQLRequestBody.setQuery(query);
        graphQLRequestBody.setVariables(variables.replace("name", name));
        return webClient.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(graphQLRequestBody)
                .retrieve()
                .bodyToMono(ClientDTO.class)
                .block();
    }
}
