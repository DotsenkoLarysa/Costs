package com.dots.web.Controller;

import com.dots.persistence.model.Category;
import com.dots.service.CategoryService;

import com.dots.web.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/show_all")
    public String getAllCategories(Model model) {
        List<Category> list = categoryService.getAllCategories();
        model.addAttribute("categories", list);
        return "list-categories";
    }

    @GetMapping(path={"/edit", "/edit/{id}"})
    public String editCategoryById(Model model, @PathVariable("id") Long category_id)
            throws RecordNotFoundException
    {
        if (category_id != null) {
            Category category = categoryService.getCategoryById(category_id);
            model.addAttribute("category", category);
        } else {
            model.addAttribute("category", new Category());
        }
        return "add-edit-category";
    }

    @PostMapping("/create")
    public String createOrUpdateCategory(Category category){
        categoryService.createOrUpdateCategory(category);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategoryById(Model model, @PathVariable("id") Long category_id)
            throws RecordNotFoundException
    {
        categoryService.deleteCategoryById(category_id);
        return "redirect:/";
    }

}
