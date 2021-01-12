package com.pszemek.service;

import com.pszemek.entity.UserEntity;
import com.pszemek.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public UserEntity create(UserEntity user){
        return userRepository.saveAndFlush(user);
    }
}
