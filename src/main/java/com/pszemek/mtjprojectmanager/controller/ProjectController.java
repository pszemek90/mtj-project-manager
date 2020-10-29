package com.pszemek.mtjprojectmanager.controller;

import com.pszemek.mtjprojectmanager.dto.ProjectDto;
import com.pszemek.mtjprojectmanager.mapper.ProjectMapper;
import com.pszemek.mtjprojectmanager.service.ProjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDto> getProjects(){
        return ProjectMapper.map(projectService.getAll());
    }
}
