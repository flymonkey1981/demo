package com.example.demo.data;

import javax.persistence.*;

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

}
