package com.kakao.repository;

import com.kakao.model.KakaoMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoMemberRepository extends JpaRepository<KakaoMember, Long> {

}
