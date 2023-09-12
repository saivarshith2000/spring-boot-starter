package com.saivarshith.springbootstarter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateTodoRequest {
    @NotBlank
    @Size(min = 3)
    String title;

    @NotBlank
    String content;

    @NotNull
    Boolean completed;
}
