package com.epam.tc.hw5.service;

import com.epam.tc.hw5.model.User;

public class UserCreator {

    public static final String USER_LOGIN = LoginDataProvider.getLoginData("userLogin");
    public static final String USER_PASSWORD = LoginDataProvider.getLoginData("userPassword");
    public static final String USER_NAME = LoginDataProvider.getLoginData("userName");

    public static User withCredentialsFromProperty() {
        return new User(USER_LOGIN, USER_PASSWORD, USER_NAME);
    }

    public static User withEmptyLogin() {
        return new User("", USER_PASSWORD, USER_NAME);
    }

    public static User withEmptyPassword() {
        return new User(USER_LOGIN, "", USER_NAME);
    }

    public static User withEmptyName() {
        return new User(USER_LOGIN, USER_PASSWORD, "");
    }
}
