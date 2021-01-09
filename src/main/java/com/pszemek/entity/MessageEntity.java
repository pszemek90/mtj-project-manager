package com.pszemek.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "messages")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid = UUID.randomUUID().toString();
    private String title;
    private String text;
    private Long date;
    private String category;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ProjectEntity project;

    public Long getDate() {
        return date;
    }

    public MessageEntity setDate(Long date) {
        this.date = date;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public MessageEntity setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MessageEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public MessageEntity setText(String text) {
        this.text = text;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public MessageEntity setCategory(String category) {
        this.category = category;
        return this;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public MessageEntity setProject(ProjectEntity project) {
        this.project = project;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
