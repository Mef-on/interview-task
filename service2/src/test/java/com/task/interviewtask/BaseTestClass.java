package com.task.interviewtask;

import com.task.interviewtask.api.GraphQLController;
import com.task.interviewtask.excecption.ControllerExceptionHandler;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public class BaseTestClass {
    @Autowired
    private GraphQLController graphQLController;
    @Autowired
    private ControllerExceptionHandler controllerExceptionHandler;

    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders
                .standaloneSetup(graphQLController)
                .setControllerAdvice(controllerExceptionHandler);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}

