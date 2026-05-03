package com.eBasket.api.product.entity;

import com.eBasket.api.common.entity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories",
        indexes = {
                @Index(name = "idx_category_slug", columnList = "slug", unique = true),
                @Index(name = "idx_category_parent", columnList = "parent_id"),
                @Index(name = "idx_categories_active", columnList = "is_active"),
                @Index(name = "idx_category_sort", columnList = "sort_order")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_categories_slug", columnNames = "slug")
        })
@Getter
@Setter
public class Category extends AuditableEntity {
    @Column(name = "slug", nullable = false, unique = true, length = 100)
    private String slug;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "logo_url", length = 500)
    private String logoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("sortOrder ASC")
    private List<Category> children = new ArrayList<>();

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "is_featured", nullable = false)
    private Boolean isFeatured = false;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder = 0;

    @Column(name = "level", nullable = false)
    private Integer level = 0;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

    //Business Logic
    public void addChild(Category child) {
        children.add(child);
        child.setParent(this);
        child.setLevel(this.level + 1);
    }

    public void removeChild(Category child) {
        children.remove(child);
        child.setParent(null);
        child.setLevel(0);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setCategory(null);
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children == null || children.isEmpty();
    }

    public String getFullPath() {
        if (parent == null) {
            return name;
        }
        return parent.getFullPath() + " > " + name;
    }

    @PrePersist
    @PreUpdate
    private void updateLevel() {
        if (parent == null) {
            this.level = 0;
        } else {
            this.level = parent.getLevel() + 1;
        }
    }
}
