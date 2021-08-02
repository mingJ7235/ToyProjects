package com.kakao.dto;

import com.kakao.model.KakaoMember;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KakaoMemberDto {
    private String userName;
    private String userEmail;

    public KakaoMemberDto (KakaoMember entity) {
        this.userName = entity.getUserName();
        this.userEmail = entity.getUserEmail();
    }

    public KakaoMember toEntity () {
        return KakaoMember.builder()
                .userName(userName)
                .userEmail(userEmail)
                .build();
    }
}
