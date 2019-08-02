package com.tedbilgar.cookapp.web.controllers;

import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.services.TestService;
import com.tedbilgar.cookapp.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("t1")
    public ResponseEntity<UserDTO> getString(){
        return ResponseEntity.ok(testService.getUserEnteties());
    }
}
