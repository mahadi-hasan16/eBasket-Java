package com.eBasket.api.product.mapper;

import com.eBasket.api.product.dto.brand.response.BrandResponse;
import com.eBasket.api.product.entity.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandResponse toDto(Brand brand);
    List<BrandResponse> toDto(List<Brand> brands);

    Brand toEntity(BrandResponse brand);
    List<Brand> toEntity(List<BrandResponse> brands);
}
