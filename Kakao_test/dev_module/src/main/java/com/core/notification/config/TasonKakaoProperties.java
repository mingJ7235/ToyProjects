package com.core.notification.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Getter
@Setter
@Configuration
//@ConditionalOnExpression("${tason.kakao.enable:false}")
@ConfigurationProperties ("tason.kakao") //yml 파일의 이름을 불러온다.
public class TasonKakaoProperties {

    private String host;

    private String tasId;

    private String authKey;

    private String sender;

    private String senderName;


}