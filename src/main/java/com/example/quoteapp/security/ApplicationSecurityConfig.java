package com.example.quoteapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ApplicationSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails regularUser = User.builder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails moderatorUser = User.builder()
                .username("moderator")
                .password("moderatorpassword")
                .roles("MODERATOR")
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password("adminpassword")
                .roles("ADMIN")
                .build();


        return new InMemoryUserDetailsManager(regularUser, moderatorUser, adminUser);
    }


}
