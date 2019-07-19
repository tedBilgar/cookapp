package com.tedbilgar.cookapp.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class TestController {

    @GetMapping("t1")
    public ResponseEntity<String> getString(){
        return ResponseEntity.ok("Hello World");
    }
}
