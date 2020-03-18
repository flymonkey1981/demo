package com.example.demo.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    String comment;

    String rate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products = new ArrayList<>();;



    protected Orders(){}

    public Orders(String comment, String rate){
        this.comment = comment;
        this.rate = rate;
    }

    public String getComment() {
        return this.comment;
    }

    public String getRate() {
        return this.rate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }




    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
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

}
