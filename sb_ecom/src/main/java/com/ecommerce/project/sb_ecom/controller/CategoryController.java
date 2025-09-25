package com.ecommerce.project.sb_ecom.controller;

import com.ecommerce.project.sb_ecom.project.model.Category;
import com.ecommerce.project.sb_ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getALlCategories(){

            List<Category> categories = categoryService.getAllCategories();
            return new ResponseEntity<>(categories, HttpStatus.OK);

    }
    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        try {
            categoryService.createCategory(category);
            return new ResponseEntity<>("Category added successfully", HttpStatus.OK);
        }
        catch(ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String>  deleteCategory(@PathVariable Long categoryId)
    {  try {
        String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status , HttpStatus.OK);
        }
        catch(ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }

    }



}
