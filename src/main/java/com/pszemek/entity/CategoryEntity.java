package com.pszemek.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid = UUID.randomUUID().toString();
    private String title;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ProjectEntity project;

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public CategoryEntity setUuid(String uuid) {
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
