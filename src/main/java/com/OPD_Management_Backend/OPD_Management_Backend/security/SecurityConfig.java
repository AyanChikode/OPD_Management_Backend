package com.OPD_Management_Backend.OPD_Management_Backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	 @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
   	  http
         .csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(auth -> auth
             .requestMatchers(
                 "/doctors/register",
                 "/auth/login"
             ).permitAll()
             .anyRequest().authenticated()
         )
         .formLogin(form -> form.disable()) 
         .httpBasic(basic -> {});              

     return http.build();
   }

}
