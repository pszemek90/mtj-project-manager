package com.pszemek.mtjprojectmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "categories")
@JsonIgnoreProperties("project")
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
