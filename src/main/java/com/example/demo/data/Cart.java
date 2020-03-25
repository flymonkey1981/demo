package com.example.demo.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date createDate;

    private Date modifyDate;

    private String voucherCode;

    @OneToOne(mappedBy = "cart")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products = new ArrayList<>();

    protected Cart(){}

    public Cart(String voucherCode, Date createDate){
        this.voucherCode = voucherCode;
        this.createDate = createDate;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void addProduct(Product product) {
        products.add(product);

    }

    public void removeProduct(Product product) {
        products.remove(product);

    }

    public List<Product> getProducts() {
        return products;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }
}
