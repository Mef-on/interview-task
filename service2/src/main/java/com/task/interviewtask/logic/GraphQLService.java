package com.task.interviewtask.logic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.task.interviewtask.model.ClientDTO;
import com.task.interviewtask.repository.ClientRepo;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
//public class GraphQLService implements GraphQLQueryResolver {
public class GraphQLService {
    private GraphQL graphQL;
//    private final String url;

    @Autowired
    private ClientRepo clientRepo;

    @Value("clients.graphql")
    private ClassPathResource classPathResource;


//    public GraphQLService(@Value("http://localhost:8081/graphqlp") String url) {
//        this.url = url;
//    }

    @PostConstruct
    private void loadSchema() throws IOException {
        InputStream inputStream = classPathResource.getInputStream();
        Reader targetReader = new InputStreamReader(inputStream);

        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(targetReader);
        RuntimeWiring runtimeWiring = buildRuntimeWriting();

        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();

    }

    private RuntimeWiring buildRuntimeWriting() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("getAllClients", clientRepo))
                .build();
    }

    public GraphQL initiateGraphQL() {
        return graphQL;
    }

    public List<ClientDTO> getAllClients(int size) {
        String json = WebClient.builder()
                .baseUrl("http://localhost:8080/generate")
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/json/{size}")
                        .build(1))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Gson gson = new Gson();

        return gson.fromJson(json, new TypeToken<ArrayList<ClientDTO>>() {
        }.getType());
    }


}
