package com.pszemek.dto;

import java.util.UUID;

public class CategoryDto implements Comparable<CategoryDto> {
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

    @Override
    public int compareTo(CategoryDto categoryDto) {
        return this.getTitle().compareTo(categoryDto.getTitle());
    }
}
