package com.pszemek.dto;

import java.util.UUID;

public class MessageDto implements Comparable<MessageDto> {
    private UUID uuid;
    private String title;
    private String text;
    private String category;
    private String project;
    private Long date;

    public Long getDate() {
        return date;
    }

    public MessageDto setDate(Long date) {
        this.date = date;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public MessageDto setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MessageDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public MessageDto setText(String text) {
        this.text = text;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public MessageDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getProject() {
        return project;
    }

    public MessageDto setProject(String project) {
        this.project = project;
        return this;
    }

    @Override
    public int compareTo(MessageDto messageDto) {
        if (messageDto != null) {
            return messageDto.getDate().compareTo(this.getDate());
        } else{
            return 1;
        }
    }
}
