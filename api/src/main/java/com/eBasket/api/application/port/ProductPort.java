package com.eBasket.api.application.port;

import com.eBasket.api.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductPort {
    Product saveProduct(Product product);
    Optional<Product> findProductById(Long id);
    List<Product> findAllProducts();
    Page<Product> findAllProducts(Pageable pageable);
    void deleteProductById(Long id);
    Product updateProduct(Long id, Product product);
    List<Product> findByBrand(String brand);
    List<Product> findByBrandIn(List<String> brands);
    List<Product> findByType(String type);
    List<Product> findByTypeIn(List<String> types);
    List<Product> findByBrandInAndTypeIn(List<String> brands, List<String> types);
    List<Product> searchByName(String searchTerm);
    List<String> findAllBrands();
    List<String> findAllTypes();
}
