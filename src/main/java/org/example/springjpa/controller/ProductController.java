package org.example.springjpa.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjpa.model.Category;
import org.example.springjpa.model.Product;
import org.example.springjpa.repository.CategoryRepository;
import org.example.springjpa.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @PostMapping("/{categoryId}")
    public Product create(@PathVariable int categoryId, @RequestBody Product product) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        product.setCategory(category);

        return productRepository.save(product);
    }
}
