package com.task.interviewtask.logic;

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

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
@Slf4j
public class GraphQLService {
    private GraphQL graphQL;

    @Autowired
    private ClientRepo clientRepo;

    @Value("clients.graphql")
    private ClassPathResource classPathResource;

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
                        .dataFetcher("getAllFlatClients", clientRepo))
                .build();
    }

    public GraphQL initiateGraphQL() {
        return graphQL;
    }
}
