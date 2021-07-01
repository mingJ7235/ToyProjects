package com.joshua.springweb.awsspring.web;

import com.joshua.springweb.awsspring.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/hello/dto")
                                //@RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션이다.
    public HelloResponseDto helloDto (@RequestParam ("name") String name, @RequestParam ("amount") int amount) {

        return new HelloResponseDto(name, amount);
    }

}
