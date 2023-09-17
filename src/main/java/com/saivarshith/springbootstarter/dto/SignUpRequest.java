package com.saivarshith.springbootstarter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequest {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 2, max = 64)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 64)
    private String lastName;

    @NotEmpty
    @Size(min = 8, max = 64)
    private char[] password;
}