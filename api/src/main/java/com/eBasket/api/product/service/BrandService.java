package com.eBasket.api.product.service;

import com.eBasket.api.product.dto.brand.response.BrandResponse;
import com.eBasket.api.product.entity.Brand;
import com.eBasket.api.product.mapper.BrandMapper;
import com.eBasket.api.product.repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    protected final BrandMapper brandMapper;

    public List<BrandResponse> findAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandResponse> brandResponses;
        brandResponses = brandMapper.toDto(brands);
        return brandResponses;
    }
}
