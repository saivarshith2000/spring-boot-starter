package com.saivarshith.springbootstarter.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Map;


@Getter
public class ValidationErrorsDTO {
    Map<String, String> errors;
    HttpStatus status;
    Instant timestamp;

    public ValidationErrorsDTO(Map<String, String> errors, HttpStatus status) {
        this.errors = errors;
        this.status = status;
        this.timestamp = Instant.now();
    }
}
