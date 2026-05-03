package com.eBasket.api.product.mapper;

import com.eBasket.api.product.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    void mapCategory(Category source, @MappingTarget Category target);
}
