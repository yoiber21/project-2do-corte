package org.example.project2.service;

import org.example.project2.model.Category;
import org.example.project2.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {

    ICategoryRepository categoryRepository;

    public CategoryServiceImpl(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepository.findCategoryById(Long.valueOf(id));
    }
}
