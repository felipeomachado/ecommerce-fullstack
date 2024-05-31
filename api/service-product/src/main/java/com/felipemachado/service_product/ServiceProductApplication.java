package com.felipemachado.service_product;

import com.felipemachado.service_product.entities.Product;
import com.felipemachado.service_product.enums.Status;
import com.felipemachado.service_product.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootApplication
public class ServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProductApplication.class, args);
	}

	@Autowired
	private ProductRepository repository;

	@PostConstruct
	public void init() {

		var count = repository.count();

		if (count == 0) {
			var random = new Random();
			for (int i=100; i<=120; i++) {
				var product = new Product(
						"Product " + i,
						BigDecimal.valueOf(random.nextInt(1000 - i + 1) + i),
						Status.ACTIVE
				);
				repository.saveAndFlush(product);
			}
		}
	}

}
