package com.kakao.repository;

import com.kakao.domain.KakaoTemplates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoTemplateRepository extends JpaRepository<KakaoTemplates, Long> {
}
