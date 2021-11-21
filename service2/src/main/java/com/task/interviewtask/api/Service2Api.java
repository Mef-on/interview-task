package com.task.interviewtask.api;

import com.task.interviewtask.logic.GraphQLService;
import com.task.interviewtask.model.ClientDTO;
import com.task.interviewtask.model.test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/getData")
public class Service2Api {

    private final GraphQLService graphQLService;

    public Service2Api(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> getChooseData(@RequestBody test query) throws IOException {
        String name = "name";
        graphQLService.getAllClients(query.getSize());
        return ResponseEntity.ok(null);
    }
}
