package com.eBasket.api.product.mapper;

import com.eBasket.api.product.dto.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toResponse(com.eBasket.api.product.entity.Product product)
    {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setName((String)product.getName());
        productResponse.setDescription((String)product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setImageUrl((String)product.getImageUrl());
        productResponse.setCategory(product.getCategory().getName());
        productResponse.setBrand(product.getBrand().getName());
        productResponse.setQuantityInStock(product.getQuantityInStock());
        productResponse.setInStock(product.isInStock());

        return productResponse;
    }
}
