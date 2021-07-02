package com.joshua.springweb.awsspring.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        //when
        String body = restTemplate.getForObject("/", String.class);
        //url 테스트, String.class라고 타입을 맞춰줘야함.
        //then
        assertThat(body).contains("Springboot web service test");
    }
    /**
     * URL호출시 페이지의 내용이제대로 호출되는지에 대한 테스트
     * HTML도 결국은 규칙이 있는 문자열임
     * TestRestTemplate을 통해 "/"로 호출하였을 때 index.mustache에 포함된 코드들이 있는 지 확인하는 것임.
     * aasertThat을 통해 contatins 메소드로 안에 매개변수가 포함되어있는지만 비교함
     */
}
