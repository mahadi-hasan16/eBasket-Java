package com.eBasket.api.product.enums;

public enum ProductSortField {
    NAME("name"),
    PRICE("price"),
    CREATED_AT("createdAt"),
    UPDATED_AT("updatedAt"),
    DISCOUNT_PERCENTAGE("discountPercentage");

    private final String fieldName;

    ProductSortField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public static ProductSortField fromString(String value) {
        if (value == null) return CREATED_AT;

        try {
            return ProductSortField.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return CREATED_AT;
        }
    }
}
