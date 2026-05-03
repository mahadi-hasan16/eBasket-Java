package com.eBasket.api.product.service;

import com.eBasket.api.product.entity.Category;
import com.eBasket.api.product.mapper.CategoryMapper;
import com.eBasket.api.product.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Optional<Category> getBySlug(String slug) {
        return categoryRepository.findBySlug(slug);
    }

    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> create(Category category) {
        Category savedCategory = categoryRepository.save(category);
        return Optional.of(savedCategory);
    }

    @Transactional
    public Optional<Category> update(Category category) {
        Category existingCategory = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryMapper.mapCategory(category, existingCategory);
        return Optional.of(categoryRepository.save(existingCategory));
    }

    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
