package com.eBasket.api.product.entity;

import com.eBasket.api.common.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "product_variants",
        indexes = {
                @Index(name = "idx_variants_product", columnList = "product_id"),
                @Index(name = "idx_variants_sku", columnList = "sku"),
                @Index(name = "idx_variants_active", columnList = "is_active"),
                @Index(name = "idx_variants_stock", columnList = "stock_quantity"),
                @Index(name = "idx_variants_price", columnList = "price")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_variants_sku", columnNames = "sku")
        })
@Getter
@Setter
public class ProductVariant extends AuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_variants_product"))
    private Product product;

    @Column(name = "sku", unique = true, length = 50)
    private String sku;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "compare_at_price", precision = 10, scale = 2)
    private BigDecimal compareAtPrice;

    @Column(name = "cost_price", precision = 10, scale = 2)
    private BigDecimal costPrice;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity = 0;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "option_values", columnDefinition = "jsonb")
    private Map<String, String> optionValues = new HashMap<>();

    @OneToMany(mappedBy = "variant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductImage> images = new ArrayList<>();
}
