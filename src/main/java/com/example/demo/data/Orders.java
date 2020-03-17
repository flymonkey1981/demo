package com.example.demo.data;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

}
