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

import java.util.Arrays;
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

    @GetMapping("/brands")
    public ResponseEntity<List<String>> getAllBrands()
    {
        List<String> brands= productPort.findAllBrands();
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getAllTypes()
    {
        List<String> types= productPort.findAllTypes();
        return ResponseEntity.ok(types);
    }

    @GetMapping(params = "brand")
    public ResponseEntity<List<Product>>  getAllProductsByBrand(@RequestParam String brand)
    {
        var products = productPort.findByBrand(brand);
        return ResponseEntity.ok(products);
    }

    @GetMapping(params = "brands")
    public ResponseEntity<List<Product>> getAllProductsByBrands(@RequestParam String brands)
    {
        List<String> brandList = Arrays.asList(brands.split(","));
        var products = productPort.findByBrandIn(brandList);
        return ResponseEntity.ok(products);
    }

    @GetMapping(params = "types")
    public ResponseEntity<List<Product>> getAllProductsByTypes(@RequestParam String types)
    {
        List<String> typeList = Arrays.asList(types.split(","));
        var products = productPort.findByTypeIn(typeList);
        return ResponseEntity.ok(products);
    }

    @GetMapping(params = {"brands", "types"})
    public ResponseEntity<List<Product>>  getAllProductsByBrandAndTypes(@RequestParam String brands, @RequestParam String types)
    {
        List<String> brandList = Arrays.asList(brands.split(","));
        List<String> typeList = Arrays.asList(types.split(","));

        var products = productPort.findByBrandInAndTypeIn(brandList, typeList);
        return ResponseEntity.ok(products);
    }

    @GetMapping(params = "type")
    public ResponseEntity<List<Product>>   getAllProductsByType(@RequestParam String type)
    {
        var products = productPort.findByType(type);
        return ResponseEntity.ok(products);
    }

    @GetMapping(params = "search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String search)
    {
        var products = productPort.searchByName(search);
        return ResponseEntity.ok(products);
    }
}
