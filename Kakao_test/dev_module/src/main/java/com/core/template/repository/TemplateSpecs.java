package com.core.template.repository;

import com.core.template.dto.SearchCriteriaDto;
import com.core.template.model.KakaoTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface TemplateSpecs {

    static Specification<KakaoTemplate> search (SearchCriteriaDto criteria) {
        Specification<KakaoTemplate> spec = (root, query, builder) -> {

            List<Predicate> predicates = new ArrayList<>();


            return builder.and(predicates.toArray(new Predicate[0]));
        };

        return spec;
    }

    public static Specification<KakaoTemplate> likeContent (final String content) {
        return new Specification<KakaoTemplate>() {
            @Override
            public Predicate toPredicate(Root<KakaoTemplate> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.like(root.get("content"),"%" + content + "%");
            }
        };
    }

    public static Specification<KakaoTemplate> equalContent (final String content) {
        return new Specification<KakaoTemplate>() {
            @Override
            public Predicate toPredicate(Root<KakaoTemplate> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("content"), content);
            }
        };
    }

    public static Specification<KakaoTemplate> betweenCreatedDateTim (final LocalDateTime startDateTime, final LocalDateTime endDateTime) {
        return new Specification<KakaoTemplate>() {
            @Override
            public Predicate toPredicate(Root<KakaoTemplate> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.between(root.get("cretedDateTime"), startDateTime, endDateTime);
            }
        };
    }
}
