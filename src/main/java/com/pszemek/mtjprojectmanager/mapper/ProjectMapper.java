package com.pszemek.mtjprojectmanager.mapper;

import com.pszemek.mtjprojectmanager.dto.CategoryDto;
import com.pszemek.mtjprojectmanager.dto.ProjectDto;
import com.pszemek.mtjprojectmanager.entity.ProjectEntity;
import com.pszemek.mtjprojectmanager.service.ProjectService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {

    private static ProjectService projectService;

    public static ProjectDto mapToDto(ProjectEntity entity){
        if(entity == null){
            throw new EntityNotFoundException();
        }
        return new ProjectDto()
                .setUuid(entity.getUuid())
                .setNumber(entity.getNumber())
                .setTitle(entity.getTitle())
                .setCustomer(entity.getCustomer())
                .setCategories(CategoryMapper.mapToDto(entity.getCategories())
                    .stream()
                    .map(CategoryDto::getTitle)
                    .collect(Collectors.toSet()))
                .setMessages(MessageMapper.mapToDto(entity.getMessages()));
    }

    public static List<ProjectDto> mapToDto(List<ProjectEntity> entities){
        return entities
                .stream()
                .map(ProjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public static ProjectEntity mapToEntity(ProjectDto dto){
        return new ProjectEntity()
                .setTitle(dto.getTitle())
                .setNumber(dto.getNumber())
                .setCustomer(dto.getCustomer())
                .setCategories(dto.getCategories()
                        .stream()
                        .map(category -> projectService.getOneByTitle(category))
                        .collect(Collectors.toSet()))
                .setMessages(MessageMapper.mapToEntity(dto.getMessages()));
    }

}
