package com.joshua.springweb.awsspring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * RestController : Controller를 JSON을 반환하는 Controller로 만들어준다.
 */
public class HelloController {

    @GetMapping ("/hello")
    public String hello () {
        return "hello";
    }

}
