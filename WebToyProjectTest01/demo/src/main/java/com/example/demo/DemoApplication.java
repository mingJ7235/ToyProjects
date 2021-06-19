package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//당장 JDBC 설정이 필요없고 어떤 DB를 사용할지 결정하지 않았을 경우 이걸 사용
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@RestController //ResponseBody 어노테이션기능 포함 -> 즉 return 값이 그대로 출력된다.
//@Controller의 주용도 -> view(화면)을 리턴하는 것이다. 서비스함수에 @ResponseBody를 사용하여 객체를 리턴할 수 있다.
//@RestController의 주용도는 데이터를 리턴한다.
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping ("/")
	public String hello () {
		return "Hello world ! ";
	}

}
