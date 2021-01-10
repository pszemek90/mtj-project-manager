package com.pszemek.mapper;

import com.pszemek.dto.CategoryDto;
import com.pszemek.entity.CategoryEntity;
import com.pszemek.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    private static ProjectService projectService;

    @Autowired
    public CategoryMapper(ProjectService projectService) {
        CategoryMapper.projectService = projectService;
    }

    public static CategoryDto mapToDto(CategoryEntity entity){
        return new CategoryDto()
                .setUuid(entity.getUuid())
                .setTitle(entity.getTitle())
                .setProject(entity.getProject().getUuid().toString());
    }

    public static TreeSet<CategoryDto> mapToDto(Set<CategoryEntity> entities){
        return entities.stream()
                .map(CategoryMapper::mapToDto)
                .collect(Collectors.toCollection(TreeSet::new));
    }
/* czy te metody są w ogóle potrzebne?
    public static CategoryEntity mapToEntity(CategoryDto dto){
        return new CategoryEntity()
                .setUuid(dto.getUuid())
                .setTitle(dto.getTitle())
                .setProject(projectService.getProjectByNumber(dto.getProject()));
    }

    public static Set<CategoryEntity> mapToEntity(Set<CategoryDto> dtos){
        return dtos.stream()
                .map(CategoryMapper::mapToEntity)
                .collect(Collectors.toSet());
    }*/
}
