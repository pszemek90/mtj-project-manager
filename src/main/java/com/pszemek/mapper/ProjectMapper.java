package com.pszemek.mapper;

import com.pszemek.dto.CategoryDto;
import com.pszemek.dto.ProjectDto;
import com.pszemek.entity.CategoryEntity;
import com.pszemek.entity.ProjectEntity;
import com.pszemek.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {

    private static ProjectService projectService;

    @Autowired
    public ProjectMapper(ProjectService projectService) {
        ProjectMapper.projectService = projectService;
    }

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
                    .collect(Collectors.toCollection(TreeSet::new)))
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
                        .map(category -> new CategoryEntity().setTitle(category))
                        .collect(Collectors.toSet()))
                .setMessages(MessageMapper.mapToEntity(dto.getMessages()));
    }

}
