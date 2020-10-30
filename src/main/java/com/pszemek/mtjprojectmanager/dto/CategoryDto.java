package com.pszemek.mtjprojectmanager.dto;

import java.util.List;
import java.util.UUID;

public class CategoryDto {
    private UUID uuid;
    private String title;
    private List<String> projects;

    public List<String> getProjects() {
        return projects;
    }

    public CategoryDto setProjects(List<String> projects) {
        this.projects = projects;
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
