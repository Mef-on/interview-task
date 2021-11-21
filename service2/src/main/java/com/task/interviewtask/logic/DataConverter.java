package com.task.interviewtask.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import com.task.interviewtask.model.ClientDTO;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@Builder
public class DataConverter {

    ObjectMapper objectMapper;

    public DataConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<String> covertDataStringToDataSet(String dataInQuery) {
        return Arrays.stream(dataInQuery.split(", ")).collect(Collectors.toList());
    }

    public ClientDTO convertJsonToClientDTO(String json) {
        return objectMapper.convertValue(json, ClientDTO.class);
    }

}
