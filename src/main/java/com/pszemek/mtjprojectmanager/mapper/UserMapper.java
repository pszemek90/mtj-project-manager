package com.pszemek.mtjprojectmanager.mapper;

import com.pszemek.mtjprojectmanager.dto.UserDto;
import com.pszemek.mtjprojectmanager.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto map(UserEntity entity){
        return new UserDto()
                .setUuid(entity.getUuid())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setEmail(entity.getEmail());
    }

    public static List<UserDto> map(List<UserEntity> entities){
        return entities
                .stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }

}
