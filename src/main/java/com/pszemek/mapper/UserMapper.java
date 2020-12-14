package com.pszemek.mapper;


import com.pszemek.dto.UserDto;
import com.pszemek.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto map(UserEntity entity){
        return new UserDto()
                .setUuid(entity.getUuid())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setEmail(entity.getEmail())
                .setPassword(entity.getPassword());
    }

    public static List<UserDto> map(List<UserEntity> entities){
        return entities
                .stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }

}
