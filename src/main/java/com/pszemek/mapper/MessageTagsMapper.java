package com.pszemek.mapper;

import com.pszemek.dto.MessageTagsDto;
import com.pszemek.entity.MessageTagsEntity;
import com.pszemek.service.ProjectService;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class MessageTagsMapper {

    private ProjectService projectService;

    public MessageTagsMapper(ProjectService projectService) {
        this.projectService = projectService;
    }

    public static MessageTagsDto mapToDto(MessageTagsEntity entity){
        return new MessageTagsDto()
                .setUuid(entity.getUuid())
                .setTag(entity.getTag())
                .setMessage_uuid(entity.getMessage().getUuid().toString());
    }

    public static Set<MessageTagsDto> mapToDto(Set<MessageTagsEntity> entities){
        return entities.stream()
                .map(MessageTagsMapper::mapToDto)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public MessageTagsEntity mapToEntity(MessageTagsDto dto){
        return new MessageTagsEntity()
                .setTag(dto.getTag())
                .setMessage(projectService.getMessageById(UUID.fromString(dto.getMessage_uuid())));
    }

    public Set<MessageTagsEntity> mapToEntity(Set<MessageTagsDto> dtos){
        return dtos.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toCollection(HashSet::new));
    }
}
