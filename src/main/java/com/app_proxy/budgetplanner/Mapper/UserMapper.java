package com.app_proxy.budgetplanner.Mapper;

import com.app_proxy.budgetplanner.Dto.UserDto;
import com.app_proxy.budgetplanner.Entities.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target="name", source="firstName")
    User mapToEntity(UserDto userDto);
    @Mapping(target="firstName", source="name")
    UserDto mapToDto(User user);
    List<UserDto> mapToListDtos(List<User> users);
}
