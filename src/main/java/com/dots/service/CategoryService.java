package com.dots.service;

import com.dots.persistence.model.Category;
import com.dots.persistence.repo.CategoryRepository;
import com.dots.web.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories()
    {
        List<Category> result = (List<Category>) categoryRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public Category getCategoryById(Long id) throws RecordNotFoundException
    {
        Optional<Category> user = categoryRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No category record exist for given id");
        }
    }

    public Category createOrUpdateCategory(Category category)
    {
        long maybeNull = category.getCategory_id();
        if(maybeNull == 0)
        {
            category = categoryRepository.save(category);

            return category;
        }
        else
        {
            Optional<Category> category1 = categoryRepository.findById(category.getCategory_id());

            if(category1.isPresent())
            {
                Category newEntity = category1.get();
                newEntity.setName_category(category.getName_category());
                newEntity. setParcentage(category.getParcentage());

                newEntity = categoryRepository.save(newEntity);

                return newEntity;
            } else {
                category = categoryRepository.save(category);

                return category;
            }
        }
    }

    public void deleteCategoryById(Long id) throws RecordNotFoundException
    {
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent())
        {
            categoryRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No category record exist for given id");
        }
    }

}
