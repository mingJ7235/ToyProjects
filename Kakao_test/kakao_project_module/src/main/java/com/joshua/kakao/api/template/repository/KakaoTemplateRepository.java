package com.joshua.kakao.api.template.repository;

import com.joshua.kakao.api.template.model.KakaoTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KakaoTemplateRepository extends JpaRepository<KakaoTemplate, Long>, JpaSpecificationExecutor<KakaoTemplate> {

    Optional<KakaoTemplate> findByTemplateCode (String templateCode);

    @Query ("select count(*) from KakaoTemplate k where k.templateCode = :code")
    int checkDuplicateCode (@Param("code") String code);

    @Override
    Page<KakaoTemplate> findAll(Specification<KakaoTemplate> spec, Pageable pageable);

    int deleteByTemplateCode (String templateCode);

}
