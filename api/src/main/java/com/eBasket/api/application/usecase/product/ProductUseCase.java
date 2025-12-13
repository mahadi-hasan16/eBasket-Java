package com.eBasket.api.application.usecase.product;

import com.eBasket.api.application.dto.product.request.ProductQueryRequest;
import com.eBasket.api.application.mapper.ProductMapper;
import com.eBasket.api.application.port.ProductPort;
import com.eBasket.api.application.specification.ProductSpecification;
import com.eBasket.api.domain.model.Product;
import com.eBasket.api.infrastructure.persistence.entity.ProductEntity;
import com.eBasket.api.infrastructure.persistence.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
public class ProductUseCase implements ProductPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Product saveProduct(Product product) {
        var entity = productMapper.toEntity(product);
        var savedEntity = productRepository.save(entity);
        return productMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDomain);
    }

    @Override
    public Page<Product> findAllProducts(ProductQueryRequest productQueryRequest) {
        Specification<ProductEntity> productSpecification = ProductSpecification.getProductFilters(productQueryRequest);

        Pageable pageable = createPageable(productQueryRequest);

        Page<Product> products = productRepository.findAll(productSpecification, pageable).map(productMapper :: toDomain);

        return products;
    }

    @Override
    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product not found. Id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        var existingEntity = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found. Id: " + id));

        existingEntity.setName(product.getName());
        existingEntity.setDescription(product.getDescription());
        existingEntity.setPrice(product.getPrice());
        existingEntity.setImageUrl(product.getImageUrl());
        existingEntity.setType(product.getType());
        existingEntity.setBrand(product.getBrand());
        existingEntity.setQuantityInStock(product.getQuantityInStock());

        var updatedEntity = productRepository.save(existingEntity);
        return productMapper.toDomain(updatedEntity);
    }


    @Override
    public List<String> findAllBrands() {
        return productRepository.findAllDistinctBrands().stream().toList();
    }

    @Override
    public List<String> findAllTypes() {
        return productRepository.findAllDistinctTypes();
    }

    //Creating Pageable
    private Pageable createPageable(ProductQueryRequest productQueryRequest) {
        int page = productQueryRequest.getPageNumber();
        int size = productQueryRequest.getPageSize() != null ? productQueryRequest.getPageSize() : 10;
        Sort sort = createSort(productQueryRequest.getSort());
        return PageRequest.of(page, size, sort);
    }

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
