package com.task.interviewtask.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@Slf4j
@ControllerAdvice
public class TaskExceptionHandler {
    public static final String EXCEPTION_MESSAGE = "exception";
    public static final String RESPONSE_MESSAGE = "message";

    @ExceptionHandler(IllegalSizeOfListException.class)
    public ResponseEntity<Object> illegalSizeOfListException(IllegalSizeOfListException exception) {
        log.error(EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(
                new HashMap<String, String>() {{
                    put(RESPONSE_MESSAGE, exception.getMessage());
                }},
                HttpStatus.CONFLICT);
    }
}
