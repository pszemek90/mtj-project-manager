package com.pszemek.controller;

import com.pszemek.dto.UserDto;
import com.pszemek.entity.RoleEntity;
import com.pszemek.entity.RoleEnum;
import com.pszemek.entity.UserEntity;
import com.pszemek.mapper.UserMapper;
import com.pszemek.payload.request.LoginRequest;
import com.pszemek.payload.response.JwtResponse;
import com.pszemek.payload.response.MessageResponse;
import com.pszemek.security.jwt.JwtUtils;
import com.pszemek.service.RoleService;
import com.pszemek.service.UserDetailsImpl;
import com.pszemek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getUuid(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles
        ));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){
        UserEntity userEntity = userMapper.mapToEntity(userDto);

        Set<String> strRoles = userDto.getRoles();
        Set<RoleEntity> roles = new HashSet<>();

        RoleEntity userRole = roleService.getOneRole(RoleEnum.getFromSimpleName("user"));
        roles.add(userRole);

        strRoles.forEach(role -> {
            RoleEntity entity = roleService.getOneRole(RoleEnum.getFromSimpleName(role));
            roles.add(entity);
        });

        userEntity.setRoles(roles);
        userService.create(userEntity);

        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }
}
