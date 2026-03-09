package com.eBasket.api.product.dto.brand.response;

import com.eBasket.api.product.entity.Product;

import java.util.List;

public record BrandResponse(
        Long id,
        String name,
        String description,
        String logoUrl,
        String websiteUrl,
        List<Product> products
) {
}
