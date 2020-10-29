package com.pszemek.mtjprojectmanager.dto;

import java.util.UUID;

public class UserDto {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;

    public UUID getUuid() {
        return uuid;
    }

    public UserDto setUuid(UUID uuid) {
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
