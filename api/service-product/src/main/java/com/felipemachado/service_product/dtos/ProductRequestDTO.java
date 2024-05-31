package com.felipemachado.service_product.dtos;

import com.felipemachado.service_product.entities.Product;
import com.felipemachado.service_product.enums.Status;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        BigDecimal price
) {
    public Product toEntity() {
        return new Product(
                name,
                price,
                Status.ACTIVE
        );
    }
}
