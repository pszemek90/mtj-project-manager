package com.pszemek.repository;

import com.pszemek.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    public ProjectEntity findByUuid(String uuid);
}
