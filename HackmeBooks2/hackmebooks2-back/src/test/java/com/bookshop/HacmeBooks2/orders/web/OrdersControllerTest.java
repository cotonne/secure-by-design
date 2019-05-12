package com.bookshop.HacmeBooks2.orders.web;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.security.test.context.support.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OrdersControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @WithMockUser
  @Test
  public void should_retrieve_orders() throws Exception {
    mockMvc.perform(get("/orders"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)));
  }
}