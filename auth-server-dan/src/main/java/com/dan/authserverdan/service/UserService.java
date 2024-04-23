package com.dan.authserverdan.service;

import com.dan.authserverdan.entity.User;
import com.dan.authserverdan.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
}
