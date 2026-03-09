package com.eBasket.api.product.controller;

import com.eBasket.api.common.constants.ApiConstants;
import com.eBasket.api.product.entity.Brand;
import com.eBasket.api.product.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.BRAND_BASE)
public class BrandController {
    private final BrandService brandService;
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getAllBrands")
    public List<Brand> getAllBrands() {
        brandService.findAllBrands();
        return brandService.findAllBrands();
    }
}
