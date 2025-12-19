package com.eBasket.api.product.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private String category;
    private String brand;
    private Integer quantityInStock;
    private Boolean inStock;  // Calculated field
}
