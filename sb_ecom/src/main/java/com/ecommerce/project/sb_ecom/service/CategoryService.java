package com.ecommerce.project.sb_ecom.service;

import com.ecommerce.project.sb_ecom.project.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory(Category category);


}
