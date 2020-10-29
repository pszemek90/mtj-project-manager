package com.pszemek.mtjprojectmanager.mapper;

import com.pszemek.mtjprojectmanager.dto.ProjectDto;
import com.pszemek.mtjprojectmanager.entity.ProjectEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectDto map(ProjectEntity entity){
        return new ProjectDto()
                .setUuid(entity.getUuid())
                .setNumber(entity.getNumber())
                .setTitle(entity.getTitle())
                .setCustomer(entity.getCustomer());
    }

    public static List<ProjectDto> map(List<ProjectEntity> entities){
        return entities
                .stream()
                .map(ProjectMapper::map)
                .collect(Collectors.toList());
    }

}
