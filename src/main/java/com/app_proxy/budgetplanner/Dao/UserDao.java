package com.app_proxy.budgetplanner.Dao;

import com.app_proxy.budgetplanner.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
     List<User> findAllUsers();
    void createUser (User user);
    void deleteUser(Long userId);
    boolean existsById(Long userId);
    void updateUser (User user);
    Optional<User> findById(Long id);
}
