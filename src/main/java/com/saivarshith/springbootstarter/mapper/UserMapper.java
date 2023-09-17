package com.saivarshith.springbootstarter.mapper;

import com.saivarshith.springbootstarter.dto.SignUpRequest;
import com.saivarshith.springbootstarter.dto.UserResponse;
import com.saivarshith.springbootstarter.model.TodoUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse UsertoUserReponse(TodoUser user);

    @Mapping(target = "password", ignore = true)
    TodoUser SignUptoUser(SignUpRequest request);
}
