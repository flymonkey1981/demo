package com.example.demo.dao;

import com.example.demo.data.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findBestSelling();
}
