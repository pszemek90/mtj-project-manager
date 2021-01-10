package com.pszemek.repository;

import com.pszemek.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
    ProjectEntity findByUuid(UUID uuid);
}
