package com.eBasket.api.product.repository;

import com.eBasket.api.product.dto.request.ProductQueryParams;
import com.eBasket.api.product.entity.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

public class ProductSpecification {
    public static Specification<Product> getProductFilters(ProductQueryParams productQueryParams) {
        return (root, query, criteriaBuilder) -> {
            Predicate productFilters = criteriaBuilder.conjunction();


            //Constructing the specification
            if (productQueryParams.hasBrandFilter()) {
                productFilters = criteriaBuilder.and(productFilters, root.get("brand").get("id").in(productQueryParams.getBrandIds()));
            }

            if (productQueryParams.hasCategoryFilter()) {
                productFilters = criteriaBuilder.and(productFilters, root.get("category").get("id").in(productQueryParams.getCategoryIds()));
            }

            if (productQueryParams.hasSearch()) {
                String searchPattern = "%" + productQueryParams.getSearch().toLowerCase() + "%";

                Predicate namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), searchPattern);

                Predicate descriptionPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), searchPattern);

                productFilters = criteriaBuilder.and(productFilters, criteriaBuilder.or(namePredicate, descriptionPredicate));
            }

            if (productQueryParams.hasPriceRangeFilter()) {
                BigDecimal maxPrice = productQueryParams.getMaxPrice() != null ? productQueryParams.getMaxPrice() : productQueryParams.getMinPrice();
                BigDecimal minPrice = productQueryParams.getMinPrice() != null ? productQueryParams.getMinPrice() : productQueryParams.getMaxPrice();

                Predicate priceRangePredicate = criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
                productFilters = criteriaBuilder.and(productFilters, priceRangePredicate);
            }

            return productFilters;
        };
    }
}
