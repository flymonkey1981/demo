package com.example.demo.dao;

import com.example.demo.data.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> findBestSelling() {
        return productRepository.findByIsBestSelling(true);
    }
}
