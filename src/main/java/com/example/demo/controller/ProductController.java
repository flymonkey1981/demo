package com.example.demo.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/v1/product", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductController {
}
