package com.tedbilgar.cookapp.services;

import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUserEnteties(){
        return userRepository.findAll();
    }
}
