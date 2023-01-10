package com.examun.service;

import com.examun.models.Category;

import java.util.Optional;
import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Optional<Category> getCategory(Long categoryId);
    public Set<Category> getCategories();
    public void deleteCategory(Long categoryId);


}
