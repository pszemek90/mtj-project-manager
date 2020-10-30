package com.pszemek.mtjprojectmanager.controller;

import com.pszemek.mtjprojectmanager.dto.ProjectDto;
import com.pszemek.mtjprojectmanager.entity.ProjectEntity;
import com.pszemek.mtjprojectmanager.mapper.ProjectMapper;
import com.pszemek.mtjprojectmanager.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
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
        List<ProjectDto> sortedProjects = ProjectMapper.map(projectService.getAll());
        sortedProjects.sort(Comparator.comparing(ProjectDto::getNumber));
        return sortedProjects;
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable String id){
        return ProjectMapper.map(projectService.getOneById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable String id){
        projectService.delete(id);
    }

    @PostMapping("/add")
    public ProjectDto createProject(@RequestBody ProjectEntity project){
        return ProjectMapper.map(projectService.create(project));
    }
}
