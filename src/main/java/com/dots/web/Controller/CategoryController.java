package com.dots.web.Controller;

import com.dots.persistence.model.Category;
import com.dots.persistence.repo.CategoryRepository;
import com.dots.web.exception.CategoryIdMismatchException;
import com.dots.web.exception.CategoryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

//    @GetMapping("/name/{nameCategory}")
////    public List<Category> findByName(@PathVariable String nameCategory) {
////        return categoryRepository.findByName(nameCategory);
////    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable long id) {
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }



    @PostMapping("/addcategory")
    public String createUser(@Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-category";
        }
        categoryRepository.save(category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "redirect:/index-category";
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
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
