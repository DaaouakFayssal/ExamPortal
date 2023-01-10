package com.examun.Impl;

import com.examun.models.Category;
import com.examun.repo.CategoryRepository;
import com.examun.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
       private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public void  deleteCategory(Long categoryId) {
        Category category=new Category();
        category.setCid(categoryId);
        this.categoryRepository.delete(category);
    }



}
