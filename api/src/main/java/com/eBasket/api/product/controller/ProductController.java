package com.eBasket.api.product.controller;

import com.eBasket.api.product.dto.request.ProductQueryRequest;
import com.eBasket.api.product.dto.response.ProductResponse;
import com.eBasket.api.product.entity.Product;
import com.eBasket.api.product.mapper.ProductMapper;
import com.eBasket.api.common.constants.ApiConstants;
import com.eBasket.api.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.PRODUCTS_BASE)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

//    @PostMapping
//    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
//        Product product = productMapper.toDomain(createProductRequest);
//
//        var savedProduct = productService.saveProduct(product);
//
//        ProductResponse productResponse = productMapper.toResponse(savedProduct);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
//    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(@ModelAttribute @Valid ProductQueryRequest productQueryRequest) {
        List<ProductResponse> products = productService.findAllProducts();

//        Page<ProductResponse> responses = products
//                .map(productMapper::toResponse);

        return ResponseEntity.ok(products);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
//        return productService.findProductById(id)
//                .map(productMapper::toResponse)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @Valid @RequestBody UpdateProductRequest updateProductRequest) {
//        Product product = new Product();
//
//        product.setName(updateProductRequest.getName());
//        product.setDescription(updateProductRequest.getDescription());
//        product.setPrice(updateProductRequest.getPrice());
//        product.setImageUrl(updateProductRequest.getImageUrl());
//        product.setType(updateProductRequest.getCategory());
//        product.setBrand(updateProductRequest.getBrand());
//        product.setQuantityInStock(updateProductRequest.getQuantityInStock());
//
//        Product updatedProduct = productService.updateProduct(id, product);
//
//        ProductResponse response = productMapper.toResponse(updatedProduct);
//        return ResponseEntity.ok(response);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(Long id) {
        productService.deleteProductById(id);

        return ResponseEntity.noContent().build();
    }
}
