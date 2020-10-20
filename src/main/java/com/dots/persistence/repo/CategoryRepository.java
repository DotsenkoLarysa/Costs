package com.dots.persistence.repo;

import com.dots.persistence.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    String createUser(@Valid Category category, BindingResult result, Model model);

    Category updateCategory(@RequestBody Category category, @PathVariable long id);

   // void deleteByCategory_id(@PathVariable long category_id);

    Iterable<Category> findAll();

    Category findOne(@PathVariable long category_id);

    //List<Category> findByName_category(@PathVariable String name_category);
}
