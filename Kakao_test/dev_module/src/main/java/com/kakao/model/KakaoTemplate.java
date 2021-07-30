package com.kakao.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class KakaoTemplate {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String templateCode;

    @Builder
    public KakaoTemplate(String content, String templateCode) {
        this.content = content;
        this.templateCode = templateCode;
    }
}
