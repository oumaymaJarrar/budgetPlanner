package com.app_proxy.budgetplanner.Service;

import com.app_proxy.budgetplanner.Dto.UserDto;

import java.util.List;


public interface UserService {
    List<UserDto> getAllUser();
    boolean deleteUser(Long id);
    void createUser(UserDto userDto);
    void updateUser(UserDto userDto);

    UserDto getUserById(Long id);
}
