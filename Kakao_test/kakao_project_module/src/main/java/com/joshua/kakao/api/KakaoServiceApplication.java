package com.joshua.kakao.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableFeignClients (basePackages = {"com.core"})
//@EnableDiscoveryClient
//@EntityScan ("com.core")
//@ComponentScan ("com.core")
//@EnableJpaRepositories("com.core")
@SpringBootApplication (scanBasePackages = "com.joshua.kakao")

public class KakaoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(KakaoServiceApplication.class,args);
    }
}
