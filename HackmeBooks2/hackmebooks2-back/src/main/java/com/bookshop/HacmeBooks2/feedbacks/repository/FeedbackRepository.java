package com.bookshop.HacmeBooks2.feedbacks.repository;

import com.bookshop.HacmeBooks2.feedbacks.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
  @Query("select f from Feedback f where f.product.id=?1")
  Set<Feedback> findByProductId(Integer productId);
}
