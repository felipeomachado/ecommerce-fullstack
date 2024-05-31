package com.felipemachado.service_product.services;

import com.felipemachado.service_product.entities.Product;
import com.felipemachado.service_product.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
