package com.eBasket.api.application.port;

import com.eBasket.api.application.dto.product.request.ProductQueryRequest;
import com.eBasket.api.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductPort {
    Product saveProduct(Product product);

    Optional<Product> findProductById(Long id);

    Page<Product> findAllProducts(ProductQueryRequest productQueryRequest);

    void deleteProductById(Long id);

    Product updateProduct(Long id, Product product);

    List<String> findAllBrands();

    List<String> findAllTypes();

}
