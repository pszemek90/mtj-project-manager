package com.pszemek.dto;

import java.util.TreeSet;
import java.util.UUID;

public class ProjectDto {
    private UUID uuid;
    private String number;
    private String title;
    private String customer;
    private TreeSet<String> categories;
    private TreeSet<MessageDto> messages;

    public UUID getUuid() {
        return uuid;
    }

    public TreeSet<String> getCategories() {
        return categories;
    }

    public ProjectDto setCategories(TreeSet<String> categories) {
        this.categories = categories;
        return this;
    }

    public TreeSet<MessageDto> getMessages() {
        return messages;
    }

    public ProjectDto setMessages(TreeSet<MessageDto> messages) {
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
