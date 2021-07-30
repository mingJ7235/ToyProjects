package com.kakao.domain;

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
public class KakaoTemplates {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String sender; //발신자 번호

    private String senderName; //발신자명

    private String templateCode;

    @Builder
    public KakaoTemplates(String content, String sender, String senderName, String templateCode) {
        this.content = content;
        this.sender = sender;
        this.senderName = senderName;
        this.templateCode = templateCode;
    }
}
