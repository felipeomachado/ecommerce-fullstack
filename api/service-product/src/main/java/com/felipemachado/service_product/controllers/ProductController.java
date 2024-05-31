package com.felipemachado.service_product.controllers;

import com.felipemachado.service_product.dtos.ProductRequestDTO;
import com.felipemachado.service_product.entities.Product;
import com.felipemachado.service_product.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductRequestDTO productRequest) {
        return productService.addProduct(productRequest.toEntity());
    }
}
