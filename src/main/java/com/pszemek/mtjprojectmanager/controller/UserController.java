package com.pszemek.mtjprojectmanager.controller;

import com.pszemek.mtjprojectmanager.dto.UserDto;
import com.pszemek.mtjprojectmanager.mapper.UserMapper;
import com.pszemek.mtjprojectmanager.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers(){
        return UserMapper.map(userService.getAll());
    }
}
