package com.kakao.repository;

import com.kakao.domain.KakaoMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoMessageRepository extends JpaRepository<KakaoMessage, Long> {
}
