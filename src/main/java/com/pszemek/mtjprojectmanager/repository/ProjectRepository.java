package com.pszemek.mtjprojectmanager.repository;

import com.pszemek.mtjprojectmanager.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
