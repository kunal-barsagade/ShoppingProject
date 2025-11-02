package com.ecom.productcatalog.service;

import com.ecom.productcatalog.model.category;
import com.ecom.productcatalog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
