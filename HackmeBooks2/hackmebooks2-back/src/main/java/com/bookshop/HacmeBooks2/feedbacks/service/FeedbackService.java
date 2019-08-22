package com.bookshop.HacmeBooks2.feedbacks.service;

import com.bookshop.HacmeBooks2.feedbacks.model.Feedback;
import com.bookshop.HacmeBooks2.feedbacks.repository.FeedbackRepository;
import com.bookshop.HacmeBooks2.products.model.Product;
import com.bookshop.HacmeBooks2.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class FeedbackService {

    private final FeedbackRepository repository;
    private final ProductRepository productRepository;

    public FeedbackService(FeedbackRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

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
