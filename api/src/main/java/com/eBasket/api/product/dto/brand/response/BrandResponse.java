package com.eBasket.api.product.dto.brand.response;

import com.eBasket.api.product.dto.product.response.ProductResponse;

import java.util.List;

public record BrandResponse(
        Long id,
        String name,
        String description,
        String logoUrl,
        String websiteUrl,
        List<ProductResponse> products
) {
}
