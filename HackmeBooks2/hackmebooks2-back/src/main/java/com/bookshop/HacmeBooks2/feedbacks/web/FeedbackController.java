package com.bookshop.HacmeBooks2.feedbacks.web;

import com.bookshop.HacmeBooks2.feedbacks.model.*;
import com.bookshop.HacmeBooks2.feedbacks.service.*;
import com.bookshop.HacmeBooks2.feedbacks.web.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.*;
import java.util.*;

@RestController
public class FeedbackController {

  @Autowired
  private FeedbackService service;

  @GetMapping("/feedbacks")
  public Set<Feedback> list(@RequestParam("product_id") Integer productId) {
    return service.findBy(productId);
  }

  @PostMapping("/feedbacks")
  public ResponseEntity save(@RequestBody FeedbackDTO dto) {
    Optional<Feedback> potentialFeedback = service.save(dto.feedback, dto.productId);
    return potentialFeedback.map(f ->
            ResponseEntity.created(URI.create("/feedbacks/" + f.id)).build())
            .orElse(ResponseEntity.badRequest().build());
  }
}
