package com.bookshop.HacmeBooks2.feedbacks.service;

import com.bookshop.HacmeBooks2.feedbacks.model.*;
import com.bookshop.HacmeBooks2.feedbacks.repository.*;
import com.bookshop.HacmeBooks2.products.model.*;
import com.bookshop.HacmeBooks2.products.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class FeedbackService {

  @Autowired
  private FeedbackRepository repository;
  @Autowired
  private ProductRepository productRepository;

  public Set<Feedback> findBy(Integer productId) {
    return repository.findByProductId(productId);
  }

  public Optional<Feedback> save(String feedback, int productId) {
    Optional<Product> product = productRepository.findById(productId);
    return product.map(p -> {
            Feedback newFeedback = new Feedback(feedback, p);
            return repository.save(newFeedback);
    });

  }
}
