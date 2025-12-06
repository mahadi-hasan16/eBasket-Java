package com.eBasket.api.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest {
    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    private String name;

    @Size(max = 1000, message = "Description can not exceed 1000 characters")
    private String description;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.01", message = "Price must be at least 0.01")
    @Digits(integer = 16, fraction = 2, message = "Price must have at most 16 integer digits and 2 decimal digits")
    private BigDecimal price;

    private String type;

    private String brand;

    private String imageUrl;

    @Min(value = 0, message = "Quantity can not be negative")
    private Integer quantityInStock;
}
