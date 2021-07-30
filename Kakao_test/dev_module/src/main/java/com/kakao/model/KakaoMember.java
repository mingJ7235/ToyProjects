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
public class KakaoMember {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String userEmail; //수신자 번호 (국가번호 + 핸드폰번호)

    @Builder
    public KakaoMember(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
