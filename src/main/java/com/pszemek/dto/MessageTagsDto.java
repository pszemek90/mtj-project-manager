package com.pszemek.dto;

import java.util.UUID;

public class MessageTagsDto {
    private UUID uuid;
    private String tag;
    private String message_uuid;

    public UUID getUuid() {
        return uuid;
    }

    public MessageTagsDto setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public MessageTagsDto setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getMessage_uuid() {
        return message_uuid;
    }

    public MessageTagsDto setMessage_uuid(String message_uuid) {
        this.message_uuid = message_uuid;
        return this;
    }
}
