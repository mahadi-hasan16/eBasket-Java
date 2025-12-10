package com.eBasket.api.application.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ProductQueryRequest {
    List<String> brands;
    List<String> types;
    String search;
    String sort;
    Integer pageIndex;
    Integer pageSize;

    public Integer getPageNumber() {
        return pageIndex != null ? pageIndex : 0;
    }
}
