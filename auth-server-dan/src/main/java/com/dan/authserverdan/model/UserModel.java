package com.dan.authserverdan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String userName;
    private String password;
    private String matchingPassword;
    private String firstName;
    private String lastName;
}
