package com.felipemachado.service_product.repositories;

import com.felipemachado.service_product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
