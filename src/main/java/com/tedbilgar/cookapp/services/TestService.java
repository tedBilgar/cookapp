package com.tedbilgar.cookapp.services;

import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.mappers.UserMapper;
import com.tedbilgar.cookapp.repos.UserRepository;
import com.tedbilgar.cookapp.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO getUserEnteties(){
        return userMapper.userEntityToUserDto(UserEntity.builder().id(2L).login("test")
                .firstName("Test")
                .secondName("Testov").build());
    }
}
