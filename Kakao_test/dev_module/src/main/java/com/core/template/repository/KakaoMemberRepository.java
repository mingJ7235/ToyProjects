package com.core.template.repository;

import com.core.template.model.KakaoMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoMemberRepository extends JpaRepository<KakaoMember, Long> {

}
