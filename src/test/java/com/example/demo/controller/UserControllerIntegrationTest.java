package com.example.demo.controller;

import com.example.demo.data.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerIntegrationTest {
    private final static String TEST_USER_ID = "user-id-123";
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

//    @Test
//    public void givenUser_whenUsers_thenReturnJsonArray()
//            throws Exception {
//        String sdob = "31/12/1998";
//        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(sdob);
//        User alex = new User("alexc","alex", "chen", dob, 1,"1234");
//
//        List<User> allUsers = Arrays.asList(alex);
//
//        given(service.listUsers()).willReturn(allUsers);
//
//        mvc.perform(get("/api/v1/user")
//                .with(user(TEST_USER_ID))
//                .with(csrf())
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].lastName", is(alex.getLastName())))
//                .andExpect(jsonPath("$[0].firstName", is(alex.getFirstName())));
//                //.andExpect(jsonPath("$[0].dob", is(alex.getDob())));
//    }
}
