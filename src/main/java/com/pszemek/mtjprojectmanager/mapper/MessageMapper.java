package com.pszemek.mtjprojectmanager.mapper;

import com.pszemek.mtjprojectmanager.dto.MessageDto;
import com.pszemek.mtjprojectmanager.entity.MessageEntity;

import java.util.List;
import java.util.stream.Collectors;

public class MessageMapper {
    public static MessageDto map(MessageEntity entity){
        return new MessageDto()
                .setUuid(entity.getUuid())
                .setProject(entity.getProject().getNumber())
                .setCategory(entity.getCategory())
                .setTitle(entity.getTitle())
                .setText(entity.getText());
    }

    public static List<MessageDto> map(List<MessageEntity> entities){
        return entities
                .stream().map(MessageMapper::map)
                .collect(Collectors.toList());
    }
}
