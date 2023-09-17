package com.saivarshith.springbootstarter.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Map;

@Getter
public class ErrorDTO {
    private String message;
    private HttpStatus status;
    private Instant timestamp;

    public ErrorDTO(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.timestamp = Instant.now();
    }
}
