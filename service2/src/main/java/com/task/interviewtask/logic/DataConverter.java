package com.task.interviewtask.logic;

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

    public List<String> covertDataStringToDataSet(String dataInQuery) {
        return Arrays.stream(dataInQuery.split(", ")).collect(Collectors.toList());
    }
//    public JSONObject convertDataSetToJSON(List<String> list, ClientDTO clientDTO){
//        JSONObject jsonObject = new JSONObject();
//        for (String key: list
//             ) {
//            jsonObject.put()
//
//        }
//    }

}
