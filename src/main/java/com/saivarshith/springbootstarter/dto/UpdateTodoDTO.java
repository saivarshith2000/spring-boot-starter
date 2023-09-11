package com.saivarshith.springbootstarter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UpdateTodoDTO {
    String title;
    String content;
    Boolean completed;
}
