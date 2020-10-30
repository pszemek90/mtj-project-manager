package com.pszemek.mtjprojectmanager.service;

import com.pszemek.mtjprojectmanager.entity.ProjectEntity;
import com.pszemek.mtjprojectmanager.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<ProjectEntity> getAll(){
        return repository.findAll();
    }

    public ProjectEntity getOneById(String id){
        return repository.findById(UUID.fromString(id)).orElse(null);
    }

    public ProjectEntity create(ProjectEntity project){
        return repository.saveAndFlush(project);
    }

    public void delete(String id){
        repository.deleteById(UUID.fromString(id));
    }
}
