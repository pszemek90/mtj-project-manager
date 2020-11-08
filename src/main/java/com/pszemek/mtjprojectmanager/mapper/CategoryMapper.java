package com.pszemek.mtjprojectmanager.mapper;

import com.pszemek.mtjprojectmanager.dto.CategoryDto;
import com.pszemek.mtjprojectmanager.entity.CategoryEntity;
import com.pszemek.mtjprojectmanager.service.ProjectService;

import java.util.Set;
import java.util.stream.Collectors;

public class CategoryMapper {

    private static ProjectService projectService;

    public static CategoryDto mapToDto(CategoryEntity entity){
        return new CategoryDto()
                .setUuid(entity.getUuid())
                .setTitle(entity.getTitle())
                .setProject(entity.getProject().getNumber());
    }

    public static Set<CategoryDto> mapToDto(Set<CategoryEntity> entities){
        return entities.stream()
                .map(CategoryMapper::mapToDto)
                .collect(Collectors.toSet());
    }

    public static CategoryEntity mapToEntity(CategoryDto dto){
        return new CategoryEntity()
                .setTitle(dto.getTitle())
                .setProject(projectService.getOneById(dto.getProject()));
    }

    public static Set<CategoryEntity> mapToEntity(Set<CategoryDto> dtos){
        return dtos.stream()
                .map(CategoryMapper::mapToEntity)
                .collect(Collectors.toSet());
    }
}
