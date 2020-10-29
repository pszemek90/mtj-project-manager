package com.pszemek.mtjprojectmanager.service;

import com.pszemek.mtjprojectmanager.dto.ProjectDto;
import com.pszemek.mtjprojectmanager.entity.ProjectEntity;
import com.pszemek.mtjprojectmanager.mapper.ProjectMapper;
import com.pszemek.mtjprojectmanager.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectEntity> getAll(){
        return projectRepository.findAll();
    }
}
