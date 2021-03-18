package com.codegym.demo_security.service.category;

import com.codegym.demo_security.model.Category;
import com.codegym.demo_security.repo.ICategoryRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepositery categoryRepositery;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepositery.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepositery.findAll(pageable);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepositery.findById(id).get();
    }

    @Override
    public Category save(Category category) {
        return categoryRepositery.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepositery.deleteById(id);
    }
}
