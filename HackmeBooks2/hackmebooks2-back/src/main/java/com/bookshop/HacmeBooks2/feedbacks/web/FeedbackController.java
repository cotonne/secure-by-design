package com.bookshop.HacmeBooks2.feedbacks.web;

import com.bookshop.HacmeBooks2.feedbacks.model.Feedback;
import com.bookshop.HacmeBooks2.feedbacks.service.FeedbackService;
import com.bookshop.HacmeBooks2.feedbacks.web.dto.FeedbackDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;
import java.util.Set;

@RestController
public class FeedbackController {

  private final FeedbackService service;

  public FeedbackController(FeedbackService service) {
    this.service = service;
  }

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
