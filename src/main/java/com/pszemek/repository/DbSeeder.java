package com.pszemek.repository;

import com.pszemek.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@ConditionalOnProperty(name = "projectmanager.db.recreate", havingValue = "true")
public class DbSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final MessageRepository messageRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public DbSeeder(CategoryRepository categoryRepository, MessageRepository messageRepository, ProjectRepository projectRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.categoryRepository = categoryRepository;
        this.messageRepository = messageRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        categoryRepository.deleteAll();
        messageRepository.deleteAll();
        projectRepository.deleteAll();
        userRepository.deleteAll();
        roleRepository.deleteAll();

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

        RoleEntity userRole = new RoleEntity()
                .setName(RoleEnum.ROLE_USER);
        RoleEntity modRole = new RoleEntity()
                .setName(RoleEnum.ROLE_MOD);
        RoleEntity adminRole = new RoleEntity()
                .setName(RoleEnum.ROLE_ADMIN);

        roleRepository.save(userRole);
        roleRepository.save(modRole);
        roleRepository.save(adminRole);

        UserEntity user = new UserEntity()
                .setUsername("user")
                .setPassword(encoder.encode("qwerty"))
                .setRoles(Stream.of(userRole).collect(Collectors.toCollection(HashSet::new)))
                .setEmail("user@user.com");

        UserEntity mod = new UserEntity()
                .setUsername("mod")
                .setPassword(encoder.encode("qwerty"))
                .setRoles(Stream.of(userRole, modRole).collect(Collectors.toCollection(HashSet::new)))
                .setEmail("mod@mod.com");

        UserEntity admin = new UserEntity()
                .setUsername("admin")
                .setPassword(encoder.encode("qwerty"))
                .setRoles(Stream.of(userRole, modRole, adminRole).collect(Collectors.toCollection(HashSet::new)))
                .setEmail("admin@user.com");

        userRepository.save(user);
        userRepository.save(mod);
        userRepository.save(admin);


    }
}
