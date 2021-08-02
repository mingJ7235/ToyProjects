package com.kakao.repository;

import com.kakao.model.KakaoTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoTemplateRepository extends JpaRepository<KakaoTemplate, Long> {

    Page<KakaoTemplate> finaAll (Specification<KakaoTemplate> spec, Pageable pageable);
}
