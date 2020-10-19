package com.dots.web;

import com.dots.persistence.model.Category;
import com.dots.persistence.repo.CategoryRepository;
import com.dots.web.exception.CategoryIdMismatchException;
import com.dots.web.exception.CategoryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/name/{nameCategory}")
    public List findByName(@PathVariable String nameCategory) {
        return categoryRepository.findByName(nameCategory);
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable long id) {
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category) {
        Category category1 = categoryRepository.save(category);
        return category1;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        categoryRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable long id) {
        if (category.getCategory_id() != id) {
            throw new CategoryIdMismatchException();
        }
        categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        return categoryRepository.save(category);
    }

}
