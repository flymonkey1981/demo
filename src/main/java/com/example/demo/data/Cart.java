package com.example.demo.data;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "cart")
    private User user;

}
