package com.pszemek.dto;

import java.util.UUID;

public class UserDto {
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public UserDto setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
