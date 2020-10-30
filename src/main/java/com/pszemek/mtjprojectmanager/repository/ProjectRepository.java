package com.pszemek.mtjprojectmanager.repository;

import com.pszemek.mtjprojectmanager.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
}
