package com.bookshop.HacmeBooks2.users.web;

import com.bookshop.HacmeBooks2.users.repository.UserRepository;
import com.bookshop.HacmeBooks2.users.web.dto.SignupDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// https://spring.io/guides/gs/testing-web/
//
// https://www.baeldung.com/spring-boot-testing
// https://www.baeldung.com/spring-security-integration-tests
// When using @SpringBootTest annotation to test controllers with
// Spring Security, it’s necessary to explicitly configure the filter
// chain when setting up MockMvc.
// @SpringBootTest: alternative to @ContextConfiguration
@SpringBootTest

// When using the @WebMvcTest annotation approach with Spring Security,
// MockMvc is automatically configured with the necessary filter chain
// required to test our security configuration.
// But it is not designed to test the whole stack
// DataSource is missing
// @WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private WebApplicationContext context;

    @Test
    public void shouldSignup() throws Exception {
        SignupDto model = aModel("john");
        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJson(model)))
                .andExpect(status().isOk());
        assertThat(repository.findByUsername("john")).isNotEmpty();
    }

    @Test
    public void shouldNotSignupGivenPasswordConfirmationIsNotEqualsToPassword() throws Exception {
        SignupDto model = aModel("john");
        model.password_confirmation = "NOT_EQUALS";
        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJson(model)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldNotSignupGivenUsernameIsAlreadyTaken() throws Exception {
        // Another user named bob is preloaded (cf. data.sql)
        SignupDto model = aModel("bob");
        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJson(model)))
                .andExpect(status().isConflict());
    }

    @Test
    public void shouldGrantUserProfile() throws Exception {
        SignupDto model = aModel("billy");

        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJson(model)))
                .andExpect(status().isOk());

        UserDetails billy = userDetailsService.loadUserByUsername("billy");
        assertThat(billy.getAuthorities())
                .extracting("authority")
                .containsOnly("USER_AUTHORITY");
    }

    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private SignupDto aModel(String username) {
        SignupDto model = new SignupDto();
        model.username = username;
        model.password = "P@ssw0rd!";
        model.password_confirmation = "P@ssw0rd!";
        model.first_name = "john";
        model.last_name = "doe";
        model.email = "john.doe@owasp.org";
        model.phone_number = "+33666666666";
        model.ssn = "19013";
        model.password_hint = "Password with an @, a 0 and a !";
        return model;
    }
}
