package com.bookshop.HacmeBooks2.products.web;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProductsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldListProducts() throws Exception {
    mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content", hasSize(20)));
  }

  @Test
  public void shouldFindOneProductById() throws Exception {
    mockMvc.perform(get("/products/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(1)));
  }

  @Test
  public void shouldSearchBookByTitle() throws Exception {
    mockMvc.perform(get("/products/_search?q=a good book"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is(1)));
  }
}
