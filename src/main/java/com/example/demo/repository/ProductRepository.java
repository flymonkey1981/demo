package com.example.demo.repository;

import com.example.demo.data.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByProductName(String productName);

}
