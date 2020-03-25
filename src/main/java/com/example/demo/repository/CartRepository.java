package com.example.demo.repository;

import com.example.demo.data.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Optional<Cart> findByVoucherCode(String voucherCode);
}
