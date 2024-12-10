package com.app_proxy.budgetplanner.Service.Impl;

import com.app_proxy.budgetplanner.Dao.UserDao;
import com.app_proxy.budgetplanner.Dto.UserDto;
import com.app_proxy.budgetplanner.Entities.User;
import com.app_proxy.budgetplanner.Mapper.UserMapper;
import com.app_proxy.budgetplanner.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserMapper userMapper;
    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userDao.findAllUsers();
        return userMapper.mapToListDtos(users);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userDao.existsById(id)) {
            userDao.deleteUser(id);
            return true;
        }
        return false;
    }

    @Override
    public void createUser(UserDto userDto) {
        userDao.createUser(userMapper.mapToEntity(userDto));
    }

    @Override
    public void updateUser(UserDto userDto) {

        userDao.updateUser(userMapper.mapToEntity(userDto));
    }
    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userDao.findById(id);
        return userMapper.mapToDto(user.get());
    }
}
