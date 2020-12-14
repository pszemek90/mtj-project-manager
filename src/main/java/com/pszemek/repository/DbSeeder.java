package com.pszemek.repository;

import com.pszemek.entity.CategoryEntity;
import com.pszemek.entity.MessageEntity;
import com.pszemek.entity.ProjectEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "projectmanager.db.recreate", havingValue = "true")
public class DbSeeder implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private MessageRepository messageRepository;
    private ProjectRepository projectRepository;

    public DbSeeder(CategoryRepository categoryRepository, MessageRepository messageRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.messageRepository = messageRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.categoryRepository.deleteAll();
        this.messageRepository.deleteAll();
        this.projectRepository.deleteAll();

        ProjectEntity projectEntity = new ProjectEntity()
                .setNumber("P20002")
                .setTitle("Konotopa")
                .setCustomer("Depenbrock");
        projectRepository.save(projectEntity);

        CategoryEntity categoryEntity = new CategoryEntity()
                .setTitle("architektura")
                .setProject(projectEntity);

        categoryRepository.save(categoryEntity);

        MessageEntity messageEntity = new MessageEntity()
                .setProject(projectEntity)
                .setTitle("testTitle1")
                .setText("testText1")
                .setCategory("architektura")
                .setDate(1L);

        messageRepository.save(messageEntity);

    }
}
