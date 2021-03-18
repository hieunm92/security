package com.codegym.demo_security.repo;

import com.codegym.demo_security.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepositery extends PagingAndSortingRepository<Category, Long> {
}
