package com.core.template.repository;

import com.core.template.model.KakaoTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface KakaoTemplateRepository extends JpaRepository<KakaoTemplate, Long>, JpaSpecificationExecutor<KakaoTemplate> {

    Optional<KakaoTemplate> findByTemplateCode (String templateCode);

}
