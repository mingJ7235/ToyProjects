package com.kakao.conditions;

import com.kakao.model.KakaoTemplate;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TemplateSpecs {

    public static Specification<KakaoTemplate> likeContent (final String keyword) {
        return new Specification<KakaoTemplate>() {
            @Override
            public Predicate toPredicate(Root<KakaoTemplate> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.like(root.get("contents"),"%" + keyword + "%");
            }
        };
    }

    public static Specification<KakaoTemplate> equalContent (final String keyword) {
        return new Specification<KakaoTemplate>() {
            @Override
            public Predicate toPredicate(Root<KakaoTemplate> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("content"), keyword);
            }
        };
    }
}
