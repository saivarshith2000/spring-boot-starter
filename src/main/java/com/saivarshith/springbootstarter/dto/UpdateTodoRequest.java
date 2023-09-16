package com.saivarshith.springbootstarter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateTodoRequest {
    @NotBlank
    @Size(min = 3)
    String title;

    @NotBlank
    String content;

    @NotNull
    Boolean completed;
}
