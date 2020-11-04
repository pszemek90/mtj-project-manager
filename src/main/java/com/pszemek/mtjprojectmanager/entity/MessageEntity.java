package com.pszemek.mtjprojectmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "messages")
@JsonIgnoreProperties("project")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @ColumnDefault("random_uuid()")
    private UUID uuid;
    private String title;
    private String text;
    private String category;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "uuid")
    private ProjectEntity project;

    public UUID getUuid() {
        return uuid;
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
}
