package com.bookshop.HacmeBooks2.feedbacks.web;

import org.hamcrest.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.security.test.context.support.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class FeedbackControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void should_retrieve_feedbacks_for_a_book() throws Exception {
    mockMvc.perform(get("/feedbacks?product_id=735"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
  }

  @WithMockUser
  @Test
  public void should_add_a_feedback_to_a_product() throws Exception {
    mockMvc.perform(post("/feedbacks")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content("{\"feedback\":\"good one!\", \"productId\": 735}")
    )
            .andExpect(status().isCreated())
            .andExpect(header().string("Location", containsString("/feedbacks/")));

  }
}