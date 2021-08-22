package com.joshua.kakao.api.template.repository;

import com.joshua.kakao.api.template.model.KakaoMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoMemberRepository extends JpaRepository<KakaoMember, Long> {

}
