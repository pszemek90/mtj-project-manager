package com.pszemek.mtjprojectmanager.mapper;

import com.pszemek.mtjprojectmanager.dto.MessageDto;
import com.pszemek.mtjprojectmanager.entity.MessageEntity;
import com.pszemek.mtjprojectmanager.service.ProjectService;

import java.util.Set;
import java.util.stream.Collectors;

public class MessageMapper {
    private static ProjectService projectService;

    public static MessageDto mapToDto(MessageEntity entity){
        return new MessageDto()
                .setUuid(entity.getUuid())
                .setProject(entity.getProject().getNumber())
                .setCategory(entity.getCategory())
                .setTitle(entity.getTitle())
                .setText(entity.getText());
    }

    public static Set<MessageDto> mapToDto(Set<MessageEntity> entities){
        return entities
                .stream().map(MessageMapper::mapToDto)
                .collect(Collectors.toSet());
    }

    public static MessageEntity mapToEntity(MessageDto dto){
        return new MessageEntity()
                .setTitle(dto.getTitle())
                .setText(dto.getText())
                .setCategory(dto.getCategory())
                .setProject(projectService.getOneById(dto.getProject()));
    }

    public static Set<MessageEntity> mapToEntity(Set<MessageDto> dtos){
        return dtos.stream()
                .map(MessageMapper::mapToEntity)
                .collect(Collectors.toSet());
    }
}
