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
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "project_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "uuid"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "uuid")
    )
    private Set<ProjectEntity> projects;

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

    public Set<ProjectEntity> getProjects() {
        return Objects.requireNonNullElseGet(projects, HashSet::new);
    }

    public CategoryEntity setProjects(Set<ProjectEntity> projects) {
        this.projects = projects;
        return this;
    }
}
