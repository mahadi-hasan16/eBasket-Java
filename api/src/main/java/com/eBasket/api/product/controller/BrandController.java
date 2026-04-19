package com.eBasket.api.product.controller;

import com.eBasket.api.common.constants.ApiConstants;
import com.eBasket.api.product.dto.brand.request.CreateBrandRequest;
import com.eBasket.api.product.dto.brand.response.BrandResponse;
import com.eBasket.api.product.entity.Brand;
import com.eBasket.api.product.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.BRAND_BASE)
public class BrandController {
    private final BrandService brandService;
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getAllBrands")
    public ResponseEntity<List<BrandResponse>> getAllBrands() {
        var brands = brandService.findAllBrands();
        return ResponseEntity.ok().body(brands);
    }

    @GetMapping("/getBrand/{id}")
    public ResponseEntity<BrandResponse> getBrand(@PathVariable String id) {
        Long brandId = Long.parseLong(id);
        var brand = brandService.findBrandById(brandId);
        return ResponseEntity.ok().body(brand);
    }

    @PostMapping("/addBrand")
    public Long addBrand(@RequestBody CreateBrandRequest brand) {
        Long brandId = brandService.addBrand(brand);
        return brandId;
    }
}
