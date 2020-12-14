package com.pszemek.service;

import com.pszemek.entity.UserEntity;
import com.pszemek.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserEntity> getAll(){
        return repository.findAll();
    }

    public UserEntity create(UserEntity user){
        return repository.saveAndFlush(user);
    }
}
