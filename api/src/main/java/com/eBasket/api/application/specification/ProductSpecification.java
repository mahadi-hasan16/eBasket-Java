package com.eBasket.api.application.specification;

import com.eBasket.api.infrastructure.persistence.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {
    public static Specification<ProductEntity> withFilters(List<String> brands, List<String> types, String search) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList();

            if (brands != null && !brands.isEmpty()) {
                predicates.add(root.get("brand").in(brands));
            }

            if (types != null && !types.isEmpty()) {
                predicates.add(root.get("type").in(types));
            }

            if (StringUtils.hasText(search)) {
                String searchPattern = "%" + search.toLowerCase() + "%";

                Predicate namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), searchPattern);

                Predicate descriptionPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), searchPattern);

                predicates.add(criteriaBuilder.or(namePredicate, descriptionPredicate));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
