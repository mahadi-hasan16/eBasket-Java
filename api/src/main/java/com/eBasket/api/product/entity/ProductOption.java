package com.eBasket.api.product.entity;


import com.eBasket.api.common.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_options",
        indexes = {
                @Index(name = "idx_product_options_product", columnList = "product_id"),
                @Index(name = "idx_product_options_position", columnList = "position")
        })
public class ProductOption extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_product_options_product"))
    private Product product;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "position", nullable = false)
    private Integer position = 0;

    @OneToMany(mappedBy = "option", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductOptionValue> values = new ArrayList<>();
}
