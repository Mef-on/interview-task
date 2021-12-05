package com.task.interviewtask.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.task.interviewtask.model.ClientDTO;
import com.task.interviewtask.model.FlatClientDTO;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ClientRepo implements DataFetcher<List<FlatClientDTO>> {
    private static ObjectMapper objectMapper;
    private static String serviceUrl;

    public ClientRepo(ObjectMapper objectMapper, String url) {
        this.objectMapper = objectMapper;
        this.serviceUrl = url;
    }

    @Override
    public List<FlatClientDTO> get(DataFetchingEnvironment dataFetchingEnvironment) {
        Integer size = dataFetchingEnvironment.getArgument("size");
        String json = WebClient.builder()
                .baseUrl(serviceUrl)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/json/{size}")
                        .build(size))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        List<ClientDTO> clientDTOList = new Gson()
                .fromJson(json, new TypeToken<ArrayList<ClientDTO>>() {
                }.getType());

        return clientDTOList.stream()
                .map(clientDTO -> objectMapper
                        .convertValue(clientDTO, FlatClientDTO.class)
                        .mapGeoPosition(clientDTO.getGeo_position()))
                .collect(Collectors.toList());
    }
}
