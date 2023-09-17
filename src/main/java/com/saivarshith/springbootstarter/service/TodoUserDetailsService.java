package com.saivarshith.springbootstarter.service;

import com.saivarshith.springbootstarter.dto.SignInRequest;
import com.saivarshith.springbootstarter.dto.SignUpRequest;
import com.saivarshith.springbootstarter.dto.UserResponse;
import com.saivarshith.springbootstarter.exception.AppException;
import com.saivarshith.springbootstarter.mapper.UserMapper;
import com.saivarshith.springbootstarter.model.TodoUser;
import com.saivarshith.springbootstarter.repository.TodoUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoUserDetailsService implements UserDetailsService {
    private final TodoUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("username does not exist"));
    }

    public UserResponse createUser(SignUpRequest request) {
        Optional<TodoUser> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new AppException("Email already in use", HttpStatus.BAD_REQUEST);
        }
        TodoUser user = mapper.SignUptoUser(request);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(request.getPassword())));
        TodoUser createdUser = userRepository.save(user);
        return mapper.UsertoUserReponse(createdUser);
    }

    public UserResponse signin(SignInRequest request) {
        TodoUser user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException("Invalid Credentials", HttpStatus.BAD_REQUEST));

        if (passwordEncoder.matches(CharBuffer.wrap(request.getPassword()), user.getPassword())) {
            return mapper.UsertoUserReponse(user);
        }
        throw new AppException("Invalid Credentials", HttpStatus.BAD_REQUEST);
    }
}
