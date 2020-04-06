package com.example.demo.controller;


import com.example.demo.data.Product;
import com.example.demo.data.User;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value="api/v1/product", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value="/getBestSellingProducts", method = GET)
    List<Product> getBestSellingProducts() {

        return productService.getBestSellingProducts();

    }
}
