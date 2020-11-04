package com.pszemek.mtjprojectmanager.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @ColumnDefault("random_uuid()")
    private UUID uuid;
    private String title;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "uuid")
    private ProjectEntity project;

    public UUID getUuid() {
        return uuid;
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
