package com.pszemek.controller;

import com.pszemek.dto.MessageDto;
import com.pszemek.dto.ProjectDto;
import com.pszemek.entity.CategoryEntity;
import com.pszemek.entity.MessageEntity;
import com.pszemek.entity.ProjectEntity;
import com.pszemek.mapper.MessageMapper;
import com.pszemek.mapper.ProjectMapper;
import com.pszemek.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/api/projects")
    public List<ProjectDto> getProjects() {
        List<ProjectDto> sortedProjects = ProjectMapper.mapToDto(projectService.getAll());
        sortedProjects.sort(Comparator.comparing(ProjectDto::getNumber));
        return sortedProjects;
    }

    @GetMapping("/api/projects/{uuid}")
    public ProjectDto getProjectById(@PathVariable UUID uuid) {
        return ProjectMapper.mapToDto(projectService.getProjectByUuid(uuid));
    }

    @GetMapping("/api/projects/{id}/messages/{messageUuid}")
    public MessageDto getMessage(@PathVariable String id, @PathVariable UUID messageUuid) {
        return MessageMapper.mapToDto(projectService.getMessageById(messageUuid));
    }

    @DeleteMapping("/api/projects/{uuid}")
    public void deleteProject(@PathVariable UUID uuid) {
        projectService.delete(uuid);
    }

    @PostMapping("/api/projects/add")
    public ProjectDto createProject(@RequestBody ProjectDto project) {
        ProjectEntity projectEntity = ProjectMapper.mapToEntity(project);
        projectService.create(projectEntity);
        return project;
    }

    @PutMapping("/api/projects/{uuid}")
    public ProjectDto updateProject(@PathVariable UUID uuid, @RequestBody ProjectDto project) {
        ProjectEntity existingProject = projectService.getProjectByUuid(uuid);
        ProjectEntity updatedProject = ProjectMapper.mapToEntity(project);
        updatedProject.getCategories().removeIf(category -> categoryExists(existingProject, category));
        for (CategoryEntity category : updatedProject.getCategories()) {
            existingProject.getCategories().add(category);
            category.setProject(existingProject);
        }


        updatedProject.getMessages().removeIf(message -> messageExists(existingProject, message));
        for (MessageEntity message : updatedProject.getMessages()) {
            existingProject.getMessages().add(message);
        }

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
