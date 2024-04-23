package com.dan.authserverdan.service;

import com.dan.authserverdan.entity.User;
import com.dan.authserverdan.model.UserModel;
import com.dan.authserverdan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {
        User user = User.builder()
                .role("USER")
                .userName(userModel.getUserName())
                .password(passwordEncoder.encode(userModel.getPassword()))
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName()).build();

        userRepository.save(user);
        return user;
    }
}
