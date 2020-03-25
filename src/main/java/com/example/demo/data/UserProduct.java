package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class UserProduct implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn
    private User user;

    @Id
    @ManyToOne
    @JoinColumn
    private Product product;

    private Date createDate;

    private String comment;

    private Integer rate;

    protected UserProduct(){}

    public UserProduct(User user, Product product, Date createDate, String comment, Integer rate) {
        this.user = user;
        this.product = product;
        this.createDate = createDate;
        this.comment = comment;
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProduct)) return false;
        UserProduct that = (UserProduct) o;
        return Objects.equals(user.getUserName(), that.user.getUserName()) &&
                Objects.equals(product.getProductName(), that.product.getProductName()) &&
                Objects.equals(createDate, that.createDate)&&
                Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getUserName(), product.getProductName(), createDate, rate);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }


}
