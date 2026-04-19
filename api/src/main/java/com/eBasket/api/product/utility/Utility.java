package com.eBasket.api.product.utility;

public class Utility {
    public Utility() {}
    public static String generateSlug(String text){
        String slug = text
                .trim()
                .toLowerCase()
                .replace(" ", "-")
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-");

        return slug;
    }
}
