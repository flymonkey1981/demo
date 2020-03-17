package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name="dob")
    private Date dob;

    private int status;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Orders> orders = new ArrayList<>();

    protected User() {}

    public User(String userName, String lastName, String firstName, Date dob, int status) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        this.status = status;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() { return this.firstName;}

    public Date getDob() {
        return this.dob;
    }

    public int getStatus() {
        return this.status;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addOrder(Orders order) {
        orders.add(order);
        order.setUser(this);
    }

    public void removeComment(Orders order) {
        orders.remove(order);
        order.setUser(null);
    }

    public List<Orders> getOrders(){
        return this.orders;
    }

}
