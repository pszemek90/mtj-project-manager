package com.pszemek.mtjprojectmanager.controller;

import com.pszemek.mtjprojectmanager.dto.MessageDto;
import com.pszemek.mtjprojectmanager.dto.ProjectDto;
import com.pszemek.mtjprojectmanager.entity.CategoryEntity;
import com.pszemek.mtjprojectmanager.entity.MessageEntity;
import com.pszemek.mtjprojectmanager.entity.ProjectEntity;
import com.pszemek.mtjprojectmanager.mapper.MessageMapper;
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
    public List<ProjectDto> getProjects() {
        List<ProjectDto> sortedProjects = ProjectMapper.mapToDto(projectService.getAll());
        sortedProjects.sort(Comparator.comparing(ProjectDto::getNumber));
        return sortedProjects;
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable String id) {
        return ProjectMapper.mapToDto(projectService.getProjectById(id));
    }

    @GetMapping("/{id}/messages/{messageId}")
    public MessageDto getMessage(@PathVariable String id, @PathVariable String messageId){
        return MessageMapper.mapToDto(projectService.getMessageById(messageId));
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable String id) {
        projectService.delete(id);
    }

    @PostMapping("/add")
    public ProjectDto createProject(@RequestBody ProjectDto project) {
        ProjectEntity projectEntity = ProjectMapper.mapToEntity(project);
        projectService.create(projectEntity);
        return project;
    }

    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable String id, @RequestBody ProjectDto project) {
        ProjectEntity existingProject = projectService.getProjectById(id);
        ProjectEntity updatedProject = ProjectMapper.mapToEntity(project);
        for (CategoryEntity category : updatedProject.getCategories()) {
            if (!categoryExists(existingProject, category)) {
                existingProject.getCategories().add(category);
            }
            category.setProject(existingProject);
        }

        existingProject.getCategories().removeIf(category -> !categoryExists(updatedProject, category));

        for (MessageEntity message : updatedProject.getMessages()) {
            if (message.getUuid() == null) {
                existingProject.getMessages().add(message);
            }
        }

        existingProject.getMessages().removeIf(message -> !messageExists(updatedProject, message));
        projectService.create(existingProject);
        return project;
    }

    private boolean messageExists(ProjectEntity project, MessageEntity message) {
        return project.getMessages().contains(message);
    }

    private boolean categoryExists(ProjectEntity project, CategoryEntity category) {
        return project.getCategories().contains(category);
    }

//    private boolean categoryExists(ProjectEntity project, CategoryEntity category) {
//        return project.getCategories()
//                .stream()
//                .map(CategoryEntity::getTitle)
//                .collect(Collectors.toSet())
//                .contains(category.getTitle());
//    }
}
