package com.pszemek.mtjprojectmanager.dto;

import java.util.UUID;

public class ProjectDto {
    private UUID uuid;
    private String number;
    private String title;
    private String customer;

    public UUID getUuid() {
        return uuid;
    }

    public ProjectDto setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public ProjectDto setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProjectDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public ProjectDto setCustomer(String customer) {
        this.customer = customer;
        return this;
    }
}
