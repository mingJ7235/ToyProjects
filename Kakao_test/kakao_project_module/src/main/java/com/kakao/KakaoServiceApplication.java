package com.kakao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "com.kakao")
public class KakaoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(KakaoServiceApplication.class,args);
    }
}
