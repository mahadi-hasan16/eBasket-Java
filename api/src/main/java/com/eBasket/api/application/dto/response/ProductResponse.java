package com.eBasket.api.application.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private String type;
    private String brand;
    private Integer quantityInStock;
    private Boolean inStock;  // Calculated field
}
