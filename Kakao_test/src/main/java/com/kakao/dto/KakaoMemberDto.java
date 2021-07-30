package com.kakao.dto;

import com.kakao.domain.KakaoMember;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KakaoMemberDto {
    private String user_name;
    private String user_email;

    public KakaoMemberDto (KakaoMember entity) {
        this.user_name = entity.getUserName();
        this.user_email = entity.getUserEmail();
    }

    public KakaoMember toEntity () {
        return KakaoMember.builder()
                .userName(user_name)
                .userEmail(user_email)
                .build();
    }
}
