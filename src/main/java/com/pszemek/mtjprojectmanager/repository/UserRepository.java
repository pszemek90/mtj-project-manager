package com.pszemek.mtjprojectmanager.repository;

import com.pszemek.mtjprojectmanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
