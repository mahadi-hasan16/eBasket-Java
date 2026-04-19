package com.eBasket.api.product.service;

import com.eBasket.api.product.dto.brand.request.CreateBrandRequest;
import com.eBasket.api.product.dto.brand.response.BrandResponse;
import com.eBasket.api.product.entity.Brand;
import com.eBasket.api.product.mapper.BrandMapper;
import com.eBasket.api.product.repository.BrandRepository;
import com.eBasket.api.product.utility.Utility;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

    public BrandResponse findBrandById(Long brandId) {
        Optional<Brand> brand = brandRepository.findById(brandId);
        BrandResponse brandResponse = null;
        if (brand.isPresent()) {
            brandResponse = brandMapper.toDto(brand.get());
        }
        return brandResponse;
    }

    public Long addBrand(CreateBrandRequest brand) {
        if (brand == null) {
            throw new IllegalArgumentException("Brand can not be null");
        }

        Brand brandEntity = new Brand();
        String slug = Utility.generateSlug((brand.name()));
        int i = 0;
        while (brandRepository.existsBySlug(slug)) {
            slug = slug + "-" + (i++);
        }
        brandEntity = brandMapper.toEntity(brand);
        brandEntity.setSlug(slug);
        brandEntity = brandRepository.save(brandEntity);
        return brandEntity.getId();
    }
}
