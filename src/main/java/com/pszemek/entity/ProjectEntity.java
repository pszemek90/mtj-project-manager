package com.pszemek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @ColumnDefault("random_uuid()")
    private UUID uuid;
    private String number;
    private String title;
    private String customer;
    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<CategoryEntity> categories;
    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<MessageEntity> messages;


    public UUID getUuid() {
        return uuid;
    }

    public ProjectEntity setUuid(UUID uuid) {
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
