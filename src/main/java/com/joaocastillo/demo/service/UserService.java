package com.joaocastillo.demo.service;

import com.joaocastillo.demo.domain.User;
import com.joaocastillo.demo.exceptions.BadCredentialsException;
import com.joaocastillo.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User login(String email, String password) throws BadCredentialsException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new BadCredentialsException("User not found");
        }
        if (!user.getPassword().equals(password)) {
            throw new BadCredentialsException("Invalid password");
        }
        return user;
    }

    public User signUp(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already in use");
        }
        return userRepository.save(user);
    }
}
