package org.example.springjpa.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjpa.model.Category;
import org.example.springjpa.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable int id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
