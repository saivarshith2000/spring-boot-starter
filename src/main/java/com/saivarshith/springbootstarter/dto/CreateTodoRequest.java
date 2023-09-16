package com.saivarshith.springbootstarter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTodoRequest {
    @NotBlank
    @Size(min = 3)
    String title;

    @NotBlank
    String content;
}
