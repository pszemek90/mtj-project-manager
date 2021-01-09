package com.pszemek.dto;

public class CategoryDto implements Comparable<CategoryDto> {
    private String uuid;
    private String title;
    private String project;

    public String getProject() {
        return project;
    }

    public CategoryDto setProject(String project) {
        this.project = project;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public CategoryDto setUuid(String uuid) {
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
