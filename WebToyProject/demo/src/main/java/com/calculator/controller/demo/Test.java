package com.calculator.controller.demo;

import org.springframework.web.bind.annotation.RequestMapping;

public class Test {
    @RequestMapping ("/test")
    public String test () {
        return "test";
    }

}
