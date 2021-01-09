package com.pszemek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid = UUID.randomUUID().toString();
    private String number;
    private String title;
    private String customer;
    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<CategoryEntity> categories;
    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<MessageEntity> messages;

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public ProjectEntity setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public Set<CategoryEntity> getCategories() {
        return Objects.requireNonNullElseGet(categories, HashSet::new);
    }

    public ProjectEntity setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
        return this;
    }

    public Set<MessageEntity> getMessages() {
        return Objects.requireNonNullElseGet(messages, HashSet::new);
    }

    public ProjectEntity setMessages(Set<MessageEntity> messages) {
        this.messages = messages;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public ProjectEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ProjectEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public ProjectEntity setCustomer(String customer) {
        this.customer = customer;
        return this;
    }
}
