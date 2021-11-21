package com.task.interviewtask.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.task.interviewtask.model.ClientDTO;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepo implements DataFetcher<List<ClientDTO>> {

//    @Override
//    public List<ClientDTO> get(DataFetchingEnvironment dataFetchingEnvironment) {
//        ClientDTO clientDTO = new ClientDTO();
//        clientDTO.setName("działaZRepo");
//        List<ClientDTO> clientDTOList = new ArrayList<>();
//        clientDTOList.add(clientDTO);
//
//
//        return clientDTOList;
//    } @Override
//

    @Override
    public List<ClientDTO> get(DataFetchingEnvironment dataFetchingEnvironment) {
        Integer size = dataFetchingEnvironment.getArgument("size");
        String json = WebClient.builder()
                .baseUrl("http://localhost:8080/generate")
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/json/{size}")
                        .build(size))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Gson gson = new Gson();

        return gson.fromJson(json, new TypeToken<ArrayList<ClientDTO>>() {
        }.getType());
    }

    //to na testy
//    public List<ClientDTO> getAllClients(int size) {
//        String json = WebClient.builder()
//                .baseUrl("http://localhost:8080/generate")
//                .build()
//                .get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/json/{size}")
//                        .build(1))
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//
//        Gson gson = new Gson();
//
//        return gson.fromJson(json, new TypeToken<ArrayList<ClientDTO>>() {
//        }.getType());
//    }


}
