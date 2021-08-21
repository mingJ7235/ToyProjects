package com.core.template.repository;

import com.core.template.model.KakaoTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface KakaoTemplateRepository extends JpaRepository<KakaoTemplate, Long>, JpaSpecificationExecutor<KakaoTemplate> {

    Optional<KakaoTemplate> findByTemplateCode (String templateCode);

    @Query ("select count(*) from KakaoTemplate k where k.templateCode = :code")
    int checkDuplicateCode (@Param("code") String code);

    int deleteByTemplateCode (String templateCode);

}
