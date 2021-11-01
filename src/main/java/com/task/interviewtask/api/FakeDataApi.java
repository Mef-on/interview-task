package com.task.interviewtask.api;

import com.github.javafaker.Faker;
import com.task.interviewtask.exception.IllegalSizeOfListException;
import com.task.interviewtask.logic.FakeDataGenerator;
import com.task.interviewtask.model.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@RestController
@RequiredArgsConstructor
@RequestMapping("/generate/json")
public class FakeDataApi {
    FakeDataGenerator fakeDataGenerator;

    @GetMapping(path = "/{size}")
    public ResponseEntity<List<ClientDTO>> getListOfClients(Integer size) throws IllegalSizeOfListException {
        return ResponseEntity.ok(fakeDataGenerator.generateListOfClientDTO(size));
    }
}
