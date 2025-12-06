package com.eBasket.api.domain.model;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String type;
    private String brand;
    private String imageUrl;
    private Integer quantityInStock;

    //Domain Logic Methods
    public boolean isInStock()
    {
        return quantityInStock != null && quantityInStock > 0;
    }

    public void reduceStock(Integer quantity)
    {
        if(quantityInStock == null || quantityInStock < quantity)
        {
            throw  new IllegalStateException("Insufficient stock");
        }

        quantityInStock -= quantity;
    }
}
