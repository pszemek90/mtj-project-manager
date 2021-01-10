package com.pszemek.mapper;

import com.pszemek.dto.MessageDto;
import com.pszemek.entity.MessageEntity;
import com.pszemek.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MessageMapper {
    private static ProjectService projectService;

    @Autowired
    public MessageMapper(ProjectService projectService) {
        MessageMapper.projectService = projectService;
    }

    public static MessageDto mapToDto(MessageEntity entity){
        return new MessageDto()
                .setUuid(entity.getUuid())
                .setProject(entity.getProject().getUuid().toString())
                .setCategory(entity.getCategory())
                .setTitle(entity.getTitle())
                .setDate(entity.getDate())
                .setText(entity.getText());
    }

    public static TreeSet<MessageDto> mapToDto(Set<MessageEntity> entities){
        return entities
                .stream().map(MessageMapper::mapToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static MessageEntity mapToEntity(MessageDto dto){
        return new MessageEntity()
                .setUuid(dto.getUuid() == null ? UUID.randomUUID() : dto.getUuid())
                .setTitle(dto.getTitle())
                .setText(dto.getText())
                .setCategory(dto.getCategory())
                .setProject(projectService.getProjectByUuid(UUID.fromString(dto.getProject())))
                .setDate(dto.getDate());
    }

    public static Set<MessageEntity> mapToEntity(Set<MessageDto> dtos){
        return dtos.stream()
                .map(MessageMapper::mapToEntity)
                .collect(Collectors.toSet());
    }
}
