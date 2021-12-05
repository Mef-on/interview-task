package com.task.interviewtask.excecption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    public static final String EXCEPTION_MESSAGE = "exception";
    public static final String RESPONSE_MESSAGE = "message";

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<Void> exceptionHandler(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(NoSuchKeyExistsException.class)
    public ResponseEntity<Object> noSuchKeyExistException(NoSuchKeyExistsException e) {
        log.error(EXCEPTION_MESSAGE, e);
        return new ResponseEntity<>(
                new HashMap<String, String>() {{
                    put(RESPONSE_MESSAGE, e.getMessage());
                }},
                HttpStatus.BAD_REQUEST);
    }
}
