package com.pszemek.controller;

import com.pszemek.dto.UserDto;
import com.pszemek.entity.UserEntity;
import com.pszemek.mapper.UserMapper;
import com.pszemek.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public boolean login(@RequestBody UserDto user){
        return user.getEmail().equals("pszemek@pszemek.pl") && user.getPassword().equals("password");
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }

    @GetMapping
    public List<UserDto> getUsers(){
        return UserMapper.map(userService.getAll());
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserEntity user){
        return UserMapper.map(userService.create(user));
    }
}
