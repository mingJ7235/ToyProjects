package com.kakao.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class KakaoMember {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String userEmail; //수신자 번호 (국가번호 + 핸드폰번호)


}
