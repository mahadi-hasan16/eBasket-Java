package com.eBasket.api.product.dto.product.response;

import java.math.BigDecimal;

public record ProductResponse(Long id,
                              String name,
                              String description,
                              BigDecimal price,
                              String imageUrl,
                              Long categoryId,
                              String categoryName,
                              Long brandId,
                              String brandName,
                              Integer quantityInStock,
                              Boolean inStock) {
}
