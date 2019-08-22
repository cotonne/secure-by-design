package com.bookshop.HacmeBooks2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserDetailsServiceConfiguration {
    private final DataSource dataSource;

    public UserDetailsServiceConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcUserDetailsManager userDetailsService() {
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(dataSource);
        userDetailsService.setUsersByUsernameQuery("select username,password,1 from users where username = ?");
        // https://docs.spring.io/spring-security/site/docs/current/reference/html5/#authority-groups
        userDetailsService.setEnableAuthorities(false);
        userDetailsService.setEnableGroups(true);
        return userDetailsService;
    }
}
