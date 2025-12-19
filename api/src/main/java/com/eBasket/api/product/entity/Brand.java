package com.eBasket.api.product.entity;

import com.eBasket.api.common.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "brands",
        indexes = {
                @Index(name = "idx_brand_slug", columnList = "slug", unique = true),
                @Index(name = "idx_brand_name", columnList = "name", unique = true)
        })
@Getter
@Setter
public class Brand extends AuditableEntity {
    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "slug", nullable = false, unique = true, length = 100)
    private String slug;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "logo_url", length = 500)
    private String logoUrl;

    @Column(name = "website_url", length = 500)
    private String websiteUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder = 0;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

    //Business Logic
    public void addProduct(Product product) {
        products.add(product);
        product.setBrand(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setBrand(null);
    }

    //Validation
    @PrePersist
    @PreUpdate
    private void validate() {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Brand name can not be empty.");
    }
}
