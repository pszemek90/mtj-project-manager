package com.pszemek.mapper;


import com.pszemek.dto.UserDto;
import com.pszemek.entity.RoleEnum;
import com.pszemek.entity.UserEntity;
import com.pszemek.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private  RoleService roleService;
    @Autowired
    private  PasswordEncoder encoder;


    public static UserDto map(UserEntity entity){
        return new UserDto()
                .setUuid(entity.getUuid())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setEmail(entity.getEmail())
                .setPassword(entity.getPassword())
                .setUsername(entity.getUsername())
                .setRoles(entity.getRoles()
                        .stream()
                .map(role -> role.getRoleName().getSimpleName())
                .collect(Collectors.toCollection(HashSet::new)));
    }

    public static List<UserDto> map(List<UserEntity> entities){
        return entities
                .stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }

    public  UserEntity mapToEntity(UserDto userDto) {
        return new UserEntity()
                .setEmail(userDto.getEmail())
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setEmail(userDto.getEmail())
                .setUsername(userDto.getUsername())
                .setPassword(encoder.encode(userDto.getPassword()))
                .setRoles(userDto.getRoles()
                .stream()
                .map(role -> roleService.getOneRole(RoleEnum.getFromSimpleName(role)))
                .collect(Collectors.toCollection(HashSet::new)));
    }
}
