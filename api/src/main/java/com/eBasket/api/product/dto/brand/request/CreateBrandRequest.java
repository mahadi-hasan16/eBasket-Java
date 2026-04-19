package com.eBasket.api.product.dto.brand.request;

import com.eBasket.api.common.entity.AuditableEntity;

public record CreateBrandRequest(
        String name,
        String description,
        String logoUrl,
        String websiteUrl
) {
    public CreateBrandRequest {
        if(description == null) description = "";
        if(logoUrl == null) logoUrl = "";
        if(websiteUrl == null) websiteUrl = "";
    }
}
