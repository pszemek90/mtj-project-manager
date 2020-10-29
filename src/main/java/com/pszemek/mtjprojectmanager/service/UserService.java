package com.pszemek.mtjprojectmanager.service;

import com.pszemek.mtjprojectmanager.entity.UserEntity;
import com.pszemek.mtjprojectmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }
}
