package com.eBasket.api.infrastructure.web.controller;

import com.eBasket.api.application.dto.request.CreateProductRequest;
import com.eBasket.api.application.dto.request.UpdateProductRequest;
import com.eBasket.api.application.dto.response.ProductResponse;
import com.eBasket.api.application.mapper.ProductMapper;
import com.eBasket.api.application.port.ProductPort;
import com.eBasket.api.domain.model.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductPort productPort;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponse>  createProduct(@Valid @RequestBody CreateProductRequest createProductRequest)
    {
        Product product = productMapper.toDomain(createProductRequest);

        var savedProduct = productPort.saveProduct(product);

        ProductResponse productResponse = productMapper.toResponse(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts()
    {
        List<Product> products = productPort.findAllProducts();

        List<ProductResponse> responses = products
                .stream()
                .map(productMapper :: toResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id)
    {
        return productPort.findProductById(id)
                .map(productMapper :: toResponse)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @Valid @RequestBody UpdateProductRequest updateProductRequest)
    {
        Product product = new Product();

        product.setName(updateProductRequest.getName());
        product.setDescription(updateProductRequest.getDescription());
        product.setPrice(updateProductRequest.getPrice());
        product.setImageUrl(updateProductRequest.getImageUrl());
        product.setType(updateProductRequest.getType());
        product.setBrand(updateProductRequest.getBrand());
        product.setQuantityInStock(updateProductRequest.getQuantityInStock());

        Product updatedProduct = productPort.updateProduct(id, product);

        ProductResponse response =  productMapper.toResponse(updatedProduct);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(Long id)
    {
        productPort.deleteProductById(id);

        return ResponseEntity.noContent().build();
    }
}
