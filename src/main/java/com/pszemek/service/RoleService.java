package com.pszemek.service;

import com.pszemek.entity.RoleEntity;
import com.pszemek.entity.RoleEnum;
import com.pszemek.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository1) {
        this.roleRepository = roleRepository1;
    }

    public RoleEntity getOneRole(RoleEnum roleEnum) {
        return roleRepository.findByRoleName(roleEnum)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
    }
}
