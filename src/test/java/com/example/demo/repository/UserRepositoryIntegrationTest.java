package com.example.demo.repository;

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
}
