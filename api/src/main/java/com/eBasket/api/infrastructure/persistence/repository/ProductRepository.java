package com.eBasket.api.infrastructure.persistence.repository;

import com.eBasket.api.domain.model.Product;
import com.eBasket.api.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>
{
    List<ProductEntity> findByBrand(String brand);
    List<ProductEntity> findByBrandIn(List<String> brands);
    List<ProductEntity> findByType(String type);
    List<ProductEntity> findByTypeIn(List<String> category);
    List<ProductEntity> findByBrandInAndTypeIn(List<String> brands, List<String> types);
    List<ProductEntity> findByNameContainingIgnoreCase(String name);

    @Query("SELECT DISTINCT p.brand FROM ProductEntity p ORDER BY  p.brand")
    List<String> findAllDistinctBrands();

    @Query("SELECT DISTINCT p.type FROM ProductEntity p ORDER BY  p.type")
    List<String> findAllDistinctTypes();
}
