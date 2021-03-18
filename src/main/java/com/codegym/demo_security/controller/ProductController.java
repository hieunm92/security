package com.codegym.demo_security.controller;

import com.codegym.demo_security.model.Category;
import com.codegym.demo_security.model.Product;
import com.codegym.demo_security.service.category.ICategoryService;
import com.codegym.demo_security.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("listCategory")
    public Iterable<Category> showAll() {
        return categoryService.findAll();
    }

    @GetMapping()
    public ModelAndView showAllProducts(@PageableDefault(size = 3) Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("productList", products);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView formCreate(@ModelAttribute Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("edit")
    public ModelAndView showFormEdit(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("edit")
    public ModelAndView formEdit(@ModelAttribute Product product, @RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        product.setId(id);
        productService.save(product);
        return modelAndView;
    }


}
