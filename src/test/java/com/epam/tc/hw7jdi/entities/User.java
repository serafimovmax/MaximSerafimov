package com.epam.tc.hw7jdi.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    public String name;
    public String password;
    public String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public static User USER_DEFAULT = new User("Roman", "Jdi1234", "ROMAN IOVLEV");
}
