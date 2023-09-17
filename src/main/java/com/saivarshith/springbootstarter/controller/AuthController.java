package com.saivarshith.springbootstarter.controller;

import com.saivarshith.springbootstarter.dto.SignInRequest;
import com.saivarshith.springbootstarter.dto.SignUpRequest;
import com.saivarshith.springbootstarter.dto.UserResponse;
import com.saivarshith.springbootstarter.mapper.UserMapper;
import com.saivarshith.springbootstarter.model.TodoUser;
import com.saivarshith.springbootstarter.service.JWTService;
import com.saivarshith.springbootstarter.service.TodoUserDetailsService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TodoUserDetailsService userDetailsService;
    private final JWTService jwtService;
    private final UserMapper mapper;

    @PostMapping("/signin")
    public ResponseEntity<UserResponse> signin(@RequestBody @Valid SignInRequest request) {
        UserResponse response = userDetailsService.signin(request);
        response.setToken(jwtService.generateToken(response.getEmail()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody @Valid SignUpRequest request) {
        UserResponse response = userDetailsService.createUser(request);
        response.setToken(jwtService.generateToken(response.getEmail()));
        return ResponseEntity.created(URI.create("/users/" + response.getId())).body(response);
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> me(@AuthenticationPrincipal TodoUser user) {
        UserResponse response = mapper.UsertoUserReponse(user);
        response.setToken(jwtService.generateToken(response.getEmail()));
        return ResponseEntity.ok(response);
    }
}
