package com.pszemek.mtjprojectmanager.dto;

import java.util.Set;
import java.util.UUID;

public class CategoryDto {
    private UUID uuid;
    private String title;
    private String project;

    public String getProject() {
        return project;
    }

    public CategoryDto setProject(String project) {
        this.project = project;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public CategoryDto setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CategoryDto setTitle(String title) {
        this.title = title;
        return this;
    }
}
