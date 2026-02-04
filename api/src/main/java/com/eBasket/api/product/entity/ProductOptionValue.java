package com.eBasket.api.product.entity;

import com.eBasket.api.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_option_values",
        indexes = {
                @Index(name = "idx_option_values_option", columnList = "option_id"),
                @Index(name = "idx_option_values_position", columnList = "position")
        })
@Getter
@Setter
public class ProductOptionValue extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_option_values_option"))
    private ProductOption option;

    @Column(name = "value", nullable = false, length = 100)
    private String value;

    @Column(name = "position", nullable = false)
    private Integer position = 0;
}