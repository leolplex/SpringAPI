package com.panthera.market.web.controller;

import com.panthera.market.domain.Product;
import com.panthera.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{Id}")
    public Optional<Product> getProduct(@PathVariable("Id") int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/delete/{Id}")
    public boolean delete(@PathVariable("Id") int productId) {
        return productService.delete(productId);
    }
}
