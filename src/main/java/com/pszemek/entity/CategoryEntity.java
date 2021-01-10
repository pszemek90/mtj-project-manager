package com.pszemek.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID uuid;
    private String title;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "uuid")
    private ProjectEntity project;

    public UUID getUuid() {
        return uuid;
    }

    public CategoryEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CategoryEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public CategoryEntity setProject(ProjectEntity project) {
        this.project = project;
        return this;
    }
}
