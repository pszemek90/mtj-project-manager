package com.pszemek.mtjprojectmanager.repository;

import com.pszemek.mtjprojectmanager.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
    CategoryEntity findFirstByTitle(String Title);
}
