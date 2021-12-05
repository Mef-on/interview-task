package com.task.interviewtask.api;

import com.task.interviewtask.logic.FakeDataGenerator;
import com.task.interviewtask.model.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@RequiredArgsConstructor
@RequestMapping("/generate/json")
public class FakeDataApi {
    private final FakeDataGenerator fakeDataGenerator;

    @GetMapping(path = "/{size}")
    public ResponseEntity<List<ClientDTO>> getClients(@PathVariable(name = "size") Integer size) {
        return ResponseEntity.ok(fakeDataGenerator.generateListOfClientDTO(size));
    }
}
