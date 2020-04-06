package com.example.demo.service;

import com.example.demo.dao.ProductDao;
import com.example.demo.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getBestSellingProducts() {
        return productDao.findBestSelling();
    }
}
