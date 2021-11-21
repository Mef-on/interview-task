package com.task.interviewtask.api;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.task.interviewtask.logic.GraphQLService;
import graphql.ExecutionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class GraphQLController {

    public static final String PARAMS = "PARAMS";
    public static final String SIZE = "SIZE";
    @Autowired
    GraphQLService graphQLService;

    @RequestMapping(value = "/clientData")
    public String getPreAuthDecisionData(@RequestBody String query) throws JSONException, IOException {
        ExecutionResult executionResult = graphQLService.initiateGraphQL().execute(query);
        Map<String, String> obj = (Map<String, String>) executionResult.getData();
        JSONObject jsonObject = new JSONObject(obj);

        return jsonObject.toString();
    }

    @GetMapping("/clientData/{params}")
    public String get(@PathVariable String params,
                      @RequestParam Integer size) {
        String query = "{\n" +
                "    getAllClients(size: SIZE){\n" +
                "        PARAMS\n" +
                "    }\n" +
                "}";

        Map<String, List> result = graphQLService.initiateGraphQL()
                .execute(query
                        .replace(PARAMS, params)
                        .replace(SIZE, size.toString()))
                .getData();

        List<String> list = (List<String>) result.values().stream()
                .findAny()
                .orElse(null)
                .stream()
                .map(value -> JSONObject.wrap(value))
                .map(json -> JsonFlattener.flattenAsMap(json.toString()).values())
                .map(values -> values.toString())
                .collect(Collectors.toList());

        return String.join("\n", list).replace("]","").replace("[", "");
    }
}
