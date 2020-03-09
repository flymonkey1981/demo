package com.example.demo;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableOAuth2Sso
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .oauth2ResourceServer().jwt();
        http.authorizeRequests()
                .antMatchers("/").permitAll() // allow all at home page
                .antMatchers("/img/**").permitAll()  // allow all to access static images
                .anyRequest().authenticated();  // authenticate everything else!
    }
}
