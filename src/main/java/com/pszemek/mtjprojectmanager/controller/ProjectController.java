package com.pszemek.mtjprojectmanager.controller;

import com.pszemek.mtjprojectmanager.dto.ProjectDto;
import com.pszemek.mtjprojectmanager.entity.CategoryEntity;
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
        List<ProjectDto> sortedProjects = ProjectMapper.mapToDto(projectService.getAll());
        sortedProjects.sort(Comparator.comparing(ProjectDto::getNumber));
        return sortedProjects;
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable String id){
        return ProjectMapper.mapToDto(projectService.getOneById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable String id){
        projectService.delete(id);
    }

    @PostMapping("/add")
    public ProjectDto createProject(@RequestBody ProjectDto project){
        ProjectEntity projectEntity = ProjectMapper.mapToEntity(project);
        projectService.create(projectEntity);
        return project;
    }

    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable String id, @RequestBody ProjectDto project){
        ProjectEntity existingProject = projectService.getOneById(id);
        ProjectEntity updatedProject = ProjectMapper.mapToEntity(project);
        existingProject.setMessages(updatedProject.getMessages());
        existingProject.setCategories(updatedProject.getCategories());
        projectService.create(existingProject);
        return project;

    }

//    @PostMapping("/{id}")
//    public ProjectDto updateProject(@PathVariable String id, @RequestBody CategoryEntity category){
//        ProjectEntity project = projectService.getOneById(id);
//        project.getCategories().add(category);
//        projectService.create(project);
//        return ProjectMapper.mapToDto(project);
//    }
}
