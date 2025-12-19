package com.eBasket.api.common.enums;

import org.springframework.data.domain.Sort;

public enum SortDirection {
    ASC(Sort.Direction.ASC),
    DESC(Sort.Direction.DESC);

    private final Sort.Direction direction;

    SortDirection(Sort.Direction direction) {
        this.direction = direction;
    }


    public Sort.Direction getDirection() {
        return this.direction;
    }

    public static SortDirection fromString(String value) {
        if(value == null) return SortDirection.DESC;

        try {
            return SortDirection.valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            return SortDirection.DESC;
        }
    }
}
