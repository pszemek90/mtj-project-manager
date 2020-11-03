package com.pszemek.mtjprojectmanager.mapper;

import com.pszemek.mtjprojectmanager.dto.CategoryDto;
import com.pszemek.mtjprojectmanager.entity.CategoryEntity;
import com.pszemek.mtjprojectmanager.entity.ProjectEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static CategoryDto map(CategoryEntity entity){
        return new CategoryDto()
                .setUuid(entity.getUuid())
                .setTitle(entity.getTitle())
                .setProjects(entity.getProjects()
                        .stream()
                        .map(ProjectEntity::getNumber)
                        .collect(Collectors.toSet()));
    }

    public static Set<CategoryDto> map(Set<CategoryEntity> entities){
        return entities.stream()
                .map(CategoryMapper::map)
                .collect(Collectors.toSet());
    }
}
