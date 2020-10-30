package com.pszemek.mtjprojectmanager.dto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ProjectDto {
    private UUID uuid;
    private String number;
    private String title;
    private String customer;
    private Set<String> categories;
    private List<MessageDto> messages;

    public UUID getUuid() {
        return uuid;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public ProjectDto setCategories(Set<String> categories) {
        this.categories = categories;
        return this;
    }

    public List<MessageDto> getMessages() {
        return messages;
    }

    public ProjectDto setMessages(List<MessageDto> messages) {
        this.messages = messages;
        return this;
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
