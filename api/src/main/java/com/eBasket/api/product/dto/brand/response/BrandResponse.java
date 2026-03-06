package com.eBasket.api.product.dto.brand.response;

public record BrandResponse(
        Long id,
        String name,
        String description,
        String logoUrl,
        String websiteUrl
) {
}
