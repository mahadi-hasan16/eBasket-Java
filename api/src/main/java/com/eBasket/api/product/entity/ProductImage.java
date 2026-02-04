package com.eBasket.api.product.entity;

import com.eBasket.api.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_images",
        indexes = {
                @Index(name = "idx_images_variant", columnList = "variant_id"),
                @Index(name = "idx_images_product", columnList = "product_id"),
                @Index(name = "idx_images_position", columnList = "position"),
                @Index(name = "idx_images_primary", columnList = "is_primary")
        })
@Getter
@Setter
public class ProductImage extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", foreignKey = @ForeignKey(name = "fk_images_variant"))
    private ProductVariant variant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_images_product"))
    private Product product;

    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;

    @Column(name = "alt_text", length = 255)
    private String altText;

    @Column(name = "position", nullable = false)
    private Integer position = 0;

    @Column(name = "is_primary", nullable = false)
    private Boolean isPrimary = false;
}