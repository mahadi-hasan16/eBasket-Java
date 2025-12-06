package com.eBasket.api.application.usecase.product;

import com.eBasket.api.application.mapper.ProductMapper;
import com.eBasket.api.application.port.ProductPort;
import com.eBasket.api.domain.model.Product;
import com.eBasket.api.infrastructure.persistence.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return productRepository.findById(id)
                .map(productMapper :: toDomain);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper :: toDomain)
                .toList();
    }

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(productMapper :: toDomain);
    }

    @Override
    public void deleteProductById(Long id) {
        if(!productRepository.existsById(id))
        {
            throw new IllegalArgumentException("Product not found. Id: " +id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        var existingEntity = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found. Id: " +id));

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
}
