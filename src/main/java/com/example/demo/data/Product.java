package com.example.demo.data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private String productName;
    private String productDesc;
    private Double price;
    private BigDecimal stock;
    private String productImageUrl;

    @ManyToMany(mappedBy = "products")
    List<Orders> orders  = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    List<Orders> carts  = new ArrayList<>();

    protected Product(){}


    public Product(String productName, String productDesc, Double price, BigDecimal stock) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
}
