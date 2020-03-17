package com.example.demo.repository;

import com.example.demo.data.Orders;
import com.example.demo.data.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
}
