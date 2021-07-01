package com.joshua.springweb.awsspring.web;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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

    public void hello_가리턴된다 () throws Exception {
        String hello;

        mvc.perform(get("/hello"))
    }

}
