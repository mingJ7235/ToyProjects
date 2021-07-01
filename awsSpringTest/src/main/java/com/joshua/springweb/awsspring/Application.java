package com.joshua.springweb.awsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //springApplication.run -> 내장 WAS를 실행한다.
        /**
         * 내장 WAS란, 별도로 외부에 WAS를 두지 않고, 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 의미한다.
         * 이것으로 인해 서버에 톰켓을 설치할 필요가 없고,
         * 스프링부트로 만들어진 Jar파일로 실행하면 되는 것이다.
         * 내장 WAS를 사용하는 것을 권장하는 이유 : '언제어디서나같은환경에서 스프링부트를 배포' 할 수 있기 때문이다.
         */
        SpringApplication.run(Application.class, args);
    }
}
