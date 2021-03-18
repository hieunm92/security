package com.codegym.demo_security.service.product;

import com.codegym.demo_security.model.Product;
import com.codegym.demo_security.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IService<Product> {
    Page<Product> findByProductName(String name, Pageable pageable);

    Page<Product> findByCategoryName(Long id, Pageable pageable);
}
