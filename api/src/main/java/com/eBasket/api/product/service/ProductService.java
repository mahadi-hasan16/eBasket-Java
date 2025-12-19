package com.eBasket.api.product.service;

import com.eBasket.api.product.dto.request.ProductQueryParams;
import com.eBasket.api.product.dto.response.ProductResponse;
import com.eBasket.api.product.entity.Product;
import com.eBasket.api.product.mapper.ProductMapper;
import com.eBasket.api.product.repository.ProductRepository;
import com.eBasket.api.product.repository.ProductSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }


    public List<ProductResponse> findAllProducts(ProductQueryParams productQueryParams) {
        Specification<Product> productSpecification = ProductSpecification.getProductFilters(productQueryParams);

        return productRepository.findAll(productSpecification)
                .stream()
                .map(productMapper :: toResponse)
                .toList();
    }


    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product not found. Id: " + id);
        }
        productRepository.deleteById(id);
    }


    public Product updateProduct(Long id, Product product) {
        var existingEntity = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found. Id: " + id));

        existingEntity.setName(product.getName());
        existingEntity.setDescription(product.getDescription());
        existingEntity.setPrice(product.getPrice());
        existingEntity.setImageUrl(product.getImageUrl());
        existingEntity.setType(product.getType());
        existingEntity.setBrand(product.getBrand());
        existingEntity.setQuantityInStock(product.getQuantityInStock());

        return productRepository.save(existingEntity);
    }

    //Creating Pageable
//    private Pageable createPageable(ProductQueryParams productQueryRequest) {
//        int page = productQueryRequest.getPageNumber();
//        int size = productQueryRequest.getPageSize() != null ? productQueryRequest.getPageSize() : 10;
//        Sort sort = createSort(productQueryRequest.getSort());
//        return PageRequest.of(page, size, sort);
//    }

    private Sort createSort(String sort) {
        if(sort == null) {
            return Sort.unsorted();
        }

        return switch (sort.toLowerCase()) {
            case "priceasc" -> Sort.by("price").ascending();
            case "pricedesc" -> Sort.by("price").descending();
            case "name" -> Sort.by("name").ascending();
            default -> Sort.unsorted();
        };
    }
}
