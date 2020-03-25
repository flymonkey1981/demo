package com.example.demo.repository;

import com.example.demo.data.Cart;
import com.example.demo.data.Orders;
import com.example.demo.data.Product;
import com.example.demo.data.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= NONE)
public class UserRepositoryIntegrationTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    @Test
    void testInsertUser() throws Exception {
        String sdob = "31/12/1998";
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(sdob);
        User u1 = new User("vcb", "bob", "vc", dob, 1);
        User u2 = new User("springt", "terry", "spring", dob, 1);
        User returnUser = userRepository.save(u1);
        assertThat(returnUser.getLastName())
                .isEqualTo("bob");


    }

    @Test
    void testInsertUserOrders() throws Exception {
        String sdob = "31/12/1998";
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(sdob);
        User u1 = new User("vcb", "bob", "vc", dob, 1);
        User u2 = new User("springt", "terry", "spring", dob, 1);
        User returnUser = userRepository.save(u1);
        userRepository.save(u2);
        assertThat(returnUser.getLastName())
                .isEqualTo("bob");
        Orders order = new Orders("Good product", "5");
        Orders order1 = new Orders("bad product", "1");
        returnUser.addOrder(order);
        returnUser.addOrder(order1);
        userRepository.save(returnUser);
        User user = userRepository.findByLastName("bob");
        assertThat(user.getFirstName()).isEqualTo("vc");
        assertThat(user.getOrders().size()).isEqualTo(2);
        user.getOrders().stream().filter(p -> p.getRate().equals("5")).findFirst().get().setComment("Very Good one");
        userRepository.save(user);
        User tempUser = userRepository.findByLastName("bob");
        assertThat(tempUser.getOrders().stream().filter(p -> p.getRate().equals("5")).findFirst().get().getComment())
                .isEqualTo("Very Good one");

    }

    @Test
    void testInsertUserOrderItems() throws Exception {
        String sdob = "31/12/1998";
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(sdob);
        User u1 = new User("vcb", "bob", "vc", dob, 1);
        User u2 = new User("springt", "terry", "spring", dob, 1);
        User returnUser = userRepository.save(u1);
        userRepository.save(u2);
        assertThat(returnUser.getLastName())
                .isEqualTo("bob");
        Product product_1 = new Product("Samsung", "Samsung XL", 20.98, new BigDecimal(20));
        Product product_2 = new Product("Apple", "Apple XL", 220.98, new BigDecimal(120));
        productRepository.save(product_1);
        productRepository.save(product_2);
        Orders order = new Orders("Good product", "5");
        Product product = productRepository.findByProductName("Apple").get();
        order.addProduct(product);

        //Orders order1 = new Orders("bad product", "1");
        returnUser.addOrder(order);
        //returnUser.addOrder(order1);
        userRepository.save(returnUser);
        User user = userRepository.findByLastName("bob");
        assertThat(user.getFirstName()).isEqualTo("vc");
        assertThat(user.getOrders().size()).isEqualTo(1);
        assertThat(user.getOrders().get(0).getProducts().size()).isEqualTo(2);
        user.getOrders().stream().filter(p -> p.getRate().equals("5")).findFirst().get().setComment("Very Good one");
        userRepository.save(user);
        User tempUser = userRepository.findByLastName("bob");
        assertThat(tempUser.getOrders().stream().filter(p -> p.getRate().equals("5")).findFirst().get().getComment())
                .isEqualTo("Very Good one");

    }

    @Test
    void testInsertCartItems() throws Exception {
        Cart cart = new Cart("abc-wer", new Date());
        Product product_1 = new Product("Samsung", "Samsung XL", 20.98, new BigDecimal(20));
        Product product_2 = new Product("Apple", "Apple XL", 220.98, new BigDecimal(120));
        productRepository.save(product_1);
        productRepository.save(product_2);

        Product product = productRepository.findByProductName("Apple").get();
        cart.addProduct(product);

        cartRepository.save(cart);
        Cart selectCart = cartRepository.findByVoucherCode("abc-wer").get();


        assertThat(selectCart.getProducts().size())
                .isEqualTo(1);

    }
}
