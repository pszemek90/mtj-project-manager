package com.pszemek.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "message_tags")
public class MessageTagsEntity {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID uuid;
    private String tag;
    @ManyToOne
    @JoinColumn(name = "message_uuid", referencedColumnName = "uuid")
    private MessageEntity message;

    public UUID getUuid() {
        return uuid;
    }

    public MessageTagsEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public MessageTagsEntity setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public MessageEntity getMessage() {
        return message;
    }

    public MessageTagsEntity setMessage(MessageEntity message) {
        this.message = message;
        return this;
    }
}
