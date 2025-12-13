package com.eBasket.api.application.dto.product.request;

import lombok.Data;

import java.util.List;

@Data
public class ProductQueryRequest {
    List<String> brands;
    List<String> types;
    String search;
    String sort;
    Integer pageSize;
    Integer pageIndex;

    public Integer getPageNumber() {
        return pageIndex != null ? pageIndex : 0;
    }
}
