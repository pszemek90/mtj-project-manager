package com.pszemek.repository;

import com.pszemek.entity.RoleEntity;
import com.pszemek.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByRoleName(RoleEnum roleName);
}
