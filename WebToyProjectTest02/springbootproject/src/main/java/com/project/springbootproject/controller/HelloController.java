package com.project.springbootproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping ("/test")
    public String test () {
        return "Hello World 룰루 테스트 데브 테스트 1123 11";
    }
}
