package com.bookshop.HacmeBooks2.configuration;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.cors.*;

import java.util.*;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  protected void configure(HttpSecurity http) throws Exception {
    http
            .cors()
            .and()
            .authorizeRequests()
            .antMatchers("/products/**").permitAll()
            .antMatchers("/feedbacks/**").permitAll()
            .antMatchers("/resources/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            .csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth)
          throws Exception {
    auth
            .inMemoryAuthentication()
            .withUser("user")
            .password("password")
            .roles("USER");
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
    configuration.setAllowedOrigins(Collections.singletonList("*"));
    configuration.setAllowedHeaders(Collections.singletonList("authorization"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
