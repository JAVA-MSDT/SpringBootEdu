package com.msdt.springmvc.service;

import java.util.List;
import java.util.Optional;

import com.msdt.springmvc.entity.User;
import com.msdt.springmvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserByLoginCred(String username, String password) {
        return  userRepository.getUserByLoginCred(username, password);
    }

    public User saveUser(User user) {
       return userRepository.save(user);
    }
}
