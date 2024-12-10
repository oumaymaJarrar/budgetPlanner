package com.app_proxy.budgetplanner.Dao;

import com.app_proxy.budgetplanner.Entities.User;
import com.app_proxy.budgetplanner.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;


    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    @Override
    public boolean existsById(Long userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public void updateUser(User user) {
        if(existsById(user.getId())) {
            userRepository.save(user);
        }
        else{
            log.debug("error when updating user");
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        if(existsById(id)) {
            return userRepository.findById(id);
        }
        else {
            log.debug("error when retrieving user by id");
        }
        return Optional.empty();
    }


}
