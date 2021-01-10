package com.pszemek.service;

import com.pszemek.entity.CategoryEntity;
import com.pszemek.entity.MessageEntity;
import com.pszemek.entity.ProjectEntity;
import com.pszemek.repository.CategoryRepository;
import com.pszemek.repository.MessageRepository;
import com.pszemek.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private MessageRepository messageRepository;
    private CategoryRepository categoryRepository;

    public ProjectService(ProjectRepository projectRepository, MessageRepository messageRepository, CategoryRepository categoryRepository) {
        this.projectRepository = projectRepository;
        this.messageRepository = messageRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProjectEntity> getAll(){
        return projectRepository.findAll();
    }

    public ProjectEntity getProjectByUuid(UUID uuid){
        return projectRepository.findByUuid(uuid);
    }

    public ProjectEntity create(ProjectEntity project){
        return projectRepository.saveAndFlush(project);
    }

    public void delete(UUID uuid){
        ProjectEntity project = projectRepository.findByUuid(uuid);
        Set<MessageEntity> projectMessages = project.getMessages();
        for(MessageEntity messageEntity : projectMessages){
            projectMessages.remove(messageEntity);
            messageRepository.delete(messageEntity);
        }
        projectRepository.delete(project);
    }

    public Optional<CategoryEntity> getCategoryByTitle(String title){
        return Optional.ofNullable(categoryRepository.findFirstByTitle(title));
    }

    public MessageEntity getMessageById(UUID uuid){
        return messageRepository.findByUuid(uuid);
    }
}
