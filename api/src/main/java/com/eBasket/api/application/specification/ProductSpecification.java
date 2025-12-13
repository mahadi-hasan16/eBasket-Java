package com.eBasket.api.application.specification;

import com.eBasket.api.application.dto.product.request.ProductQueryRequest;
import com.eBasket.api.infrastructure.persistence.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.List;

public class ProductSpecification {
    public static Specification<ProductEntity> getProductFilters(ProductQueryRequest productQueryRequest) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicates = criteriaBuilder.conjunction();

            //Getting query parameters from productQueryRequest
            List<String> brands = productQueryRequest.getBrands();
            List<String> types = productQueryRequest.getTypes();
            String search = productQueryRequest.getSearch();

            //Constructing the specification
            if (brands != null && !brands.isEmpty()) {
                predicates = criteriaBuilder.and(predicates, root.get("brand").in(productQueryRequest.getBrands()));
            }

            if (types != null && !types.isEmpty()) {
                predicates = criteriaBuilder.and(predicates, root.get("type").in(productQueryRequest.getTypes()));
            }

            if (StringUtils.hasText(search)) {
                String searchPattern = "%" + search.toLowerCase() + "%";

                Predicate namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), searchPattern);

                Predicate descriptionPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), searchPattern);

                predicates = criteriaBuilder.and(predicates, criteriaBuilder.or(namePredicate, descriptionPredicate));
            }

            return predicates;
        };
    }
}
