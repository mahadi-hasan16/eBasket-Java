package com.eBasket.api.product.dto.product.request;

import com.eBasket.api.common.enums.SortDirection;
import com.eBasket.api.product.enums.ProductSortField;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductQueryParams {
    private String search;
    private List<Long> brandIds;
    private List<Long> categoryIds;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Boolean isActive;
    private Boolean isFeatured;
    private Boolean hasDiscount;

    //Pagination
    private Integer page = 0;
    private Integer size = 20;

    //Sorting
    private ProductSortField sortBy = ProductSortField.CREATED_AT;
    private SortDirection sortDirection = SortDirection.DESC;

    //Helper functions
    public boolean hasSearch() {
        return search != null && !search.isEmpty();
    }

    public boolean hasBrandFilter() {
        return brandIds != null && !brandIds.isEmpty();
    }

    public boolean hasCategoryFilter() {
        return categoryIds != null && !categoryIds.isEmpty();
    }

    public boolean hasPriceRangeFilter() {
        return minPrice != null || maxPrice != null;
    }

    public Sort getSort() {
        return Sort.by(sortDirection.getDirection(), sortBy.getFieldName());
    }

    public Integer getPageNumber() {
        return page != null ? page : 0;
    }

    public void validate() {
        if(page < 0) page = 0;
        if(size <= 0 || size > 100) size = 20;
    }
}
