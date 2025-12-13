package com.eBasket.api.application.mapper;

import com.eBasket.api.application.dto.product.request.CreateProductRequest;
import com.eBasket.api.application.dto.product.response.ProductResponse;
import com.eBasket.api.domain.model.Product;
import com.eBasket.api.infrastructure.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toDomain(CreateProductRequest createProductRequest)
    {
        Product product = new Product();

        product.setName((String)createProductRequest.getName());
        product.setDescription((String)createProductRequest.getDescription());
        product.setPrice(createProductRequest.getPrice());
        product.setImageUrl((String)createProductRequest.getImageUrl());
        product.setType(createProductRequest.getType());
        product.setBrand(createProductRequest.getBrand());
        product.setQuantityInStock(createProductRequest.getQuantityInStock());

        return product;
    }

    public ProductEntity toEntity(Product product)
    {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setName((String)product.getName());
        productEntity.setDescription((String)product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setImageUrl((String)product.getImageUrl());
        productEntity.setType(product.getType());
        productEntity.setBrand(product.getBrand());
        productEntity.setQuantityInStock(product.getQuantityInStock());

        return productEntity;
    }

    public  Product toDomain(ProductEntity productEntity)
    {
        Product product = new Product();

        product.setName((String)productEntity.getName());
        product.setDescription((String)productEntity.getDescription());
        product.setPrice(productEntity.getPrice());
        product.setImageUrl((String)productEntity.getImageUrl());
        product.setType(productEntity.getType());
        product.setBrand(productEntity.getBrand());
        product.setQuantityInStock(productEntity.getQuantityInStock());

        return product;
    }

    public ProductResponse toResponse(Product product)
    {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setName((String)product.getName());
        productResponse.setDescription((String)product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setImageUrl((String)product.getImageUrl());
        productResponse.setType(product.getType());
        productResponse.setBrand(product.getBrand());
        productResponse.setQuantityInStock(product.getQuantityInStock());
        productResponse.setInStock(product.isInStock());

        return productResponse;
    }
}
