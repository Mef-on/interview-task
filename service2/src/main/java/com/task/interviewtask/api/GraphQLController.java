package com.task.interviewtask.api;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.task.interviewtask.excecption.NoSuchKeyExistsException;
import com.task.interviewtask.logic.GraphQLService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@EnableSwagger2
@RestController
@Validated
public class GraphQLController {
    private static final String PARAMS = "PARAMS";
    private static final String SIZE = "SIZE";
    private static final String BASIC_QUERY_PARAMS = "type, _id, name, type, latitude, longitude";

    @Setter(onMethod_ = {@Value("${queryGraphQL}")})
    private String GRAPH_QL_QUERY;

    @Autowired
    GraphQLService graphQLService;

    public GraphQLController()  {
    }

    @GetMapping("/basicDataOfClient")
    public String get(@RequestParam @Min(1) @Max(500) Integer size) throws NoSuchKeyExistsException {
        return getFromGraphQL(BASIC_QUERY_PARAMS, size);
    }

    @GetMapping("/optionalDataOfClient")
    public String get(@RequestParam String params, @Min(1) @Max(500) Integer size) throws NoSuchKeyExistsException {
        return getFromGraphQL(params, size);
    }

    private String getFromGraphQL(String params, Integer size) throws NoSuchKeyExistsException {
        Map<String, List> result = graphQLService.initiateGraphQL()
                .execute(GRAPH_QL_QUERY
                        .replace(PARAMS, validatedParams(params))
                        .replace(SIZE, size.toString()))
                .getData();

        List<String> list = (List<String>) result.values().stream()
                .findAny()
                .orElse(null)
                .stream()
                .map(JSONObject::wrap)
                .map(json -> JsonFlattener.flattenAsMap(json.toString()).values())
                .map(Object::toString)
                .collect(Collectors.toList());

        return String.join("\n", list).replace("]", "").replace("[", "");
    }

    private String validatedParams(String params) throws NoSuchKeyExistsException {
        String allKeys = "params, _id, _type, key, name, fullName, iata_airport_code, " +
                "type, country, latitude, longitude, location_id, inEurope, countryCode, coreCountry, distance";

        List<String> paramsOfList = Arrays.stream(params.split(", ")).collect(Collectors.toList());
        List<String> listOfAllKeys = Arrays.stream(allKeys.split(", ")).collect(Collectors.toList());
        if (listOfAllKeys.containsAll(paramsOfList)) {
            return params;
        } else throw new NoSuchKeyExistsException("Params has incorrect keys");
    }
}
