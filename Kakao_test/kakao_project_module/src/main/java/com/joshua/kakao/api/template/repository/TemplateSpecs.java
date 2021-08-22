package com.joshua.kakao.api.template.repository;

import com.joshua.kakao.api.template.dto.SearchCriteriaDto;
import com.joshua.kakao.api.template.model.KakaoTemplate;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

public interface TemplateSpecs {

    static Specification<KakaoTemplate> search2 (SearchCriteriaDto criteria) {
        Specification<KakaoTemplate> spec = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (isEmpty(criteria.getStartDate()) && !isEmpty(criteria.getEndDate())) {

            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return spec;
    }

    static Specification<KakaoTemplate> search (SearchCriteriaDto criteria) {
        Specification<KakaoTemplate> spec = (root, query, builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getStartDate() == null && criteria.getEndDate() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("createdAt"), criteria.getEndDate()));
            } else if (criteria.getStartDate() != null && criteria.getEndDate() == null) {
                predicates.add(builder.greaterThan(root.get("createdAt"), criteria.getStartDate()));
            } else if (criteria.getStartDate() == null && criteria.getEndDate() == null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("createdAt"), LocalDateTime.now()));
            } else {
                predicates.add(builder.between(root.get("createdAt"),
                    criteria.getStartDate(),
                    criteria.getEndDate()
                ));
            }

            if (criteria.getSearch() != null) {
                predicates.add(builder.or(
                        builder.like(root.get("subject"), "%" + criteria.getSearch() + "%"),
                        builder.like(root.get("content"), "%" + criteria.getSearch() + "%")
                ));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };

        return spec;
    }

}
