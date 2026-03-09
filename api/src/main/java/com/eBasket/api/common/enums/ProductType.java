package com.eBasket.api.common.enums;

public enum ProductType {
    SIMPLE("Simple Products - No variants"),
    CONFIGURABLE("Configurable Products - Has Variants"),
    BUNDLE("Bundle Products - Multiple Products Together"),
    DIGITAL("Digital Products - Downloadable"),
    PHYSICAL("Physical Products - Shippable");

    private final String description;

    ProductType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
