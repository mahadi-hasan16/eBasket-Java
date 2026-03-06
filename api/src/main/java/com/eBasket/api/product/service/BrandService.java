package com.eBasket.api.product.service;

import com.eBasket.api.product.repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
}
