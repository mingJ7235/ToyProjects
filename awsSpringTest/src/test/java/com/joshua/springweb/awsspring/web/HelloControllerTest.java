package com.joshua.springweb.awsspring.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
/**
 * 테스트 진행시 JUnit에 내장된 실행자 외에 다른 실행자를 실행 시킨다.
 * -> 여기서는 SpringRunner라는 스프링 실행자를 사용한다. (매개변수)
 * 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다.
 */
@WebMvcTest
/**
 * 여러 스프링 테스트 어노테이션중에 Web(Spring MVC)에 집중할 수 있는 어노테이션이다.
 * 이걸 선언할 경우 @Controller, @ControllerAdvice등을 사용할 수 있다.
 * 하지만 @Service, @Component, @Repository등은 사용할 수 없다.
 * 여기서는 Controller만 사용하기 때문에 선언해준다.
 */
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 Bean을 주입한다.
    private MockMvc mvc; //웹 API를 테스트할 때 사용한다. 스프링 MVC 테스트의 시작점이다.
                        //MockMvc 클래스를 통해 HTTP GET, POST등에 대한 API테스트를 할 수 있다.

    @Test
    public void hello_가리턴된다 () throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) //MockMvc 를 통해서 /hello 주소로 HTTP GET요청을 한다.
                                            //chaining이 지원되어서 아래와같이 여러 검증 기능을 선언할 수 있다.

            .andExpect(status().isOk())     // mvc.perform의 결과를 검증한다.
                    //HTTP Header의 status를 검증하는 것이다. 즉, 200, 404, 500 등의 상태를 검증한다.
                    //isOk() 는 OK 즉 200인지 아닌지를 검증하는 것임
            .andExpect(content().string(hello)); //mvc.perform 의 결과를 검증한다.
                    //응답 본문의 내용을 (content)를 검증한다.
                    //Controller에서 "hello"를 리턴하기때문에 이 값이 맞는지를 검증한다.
    }

}
