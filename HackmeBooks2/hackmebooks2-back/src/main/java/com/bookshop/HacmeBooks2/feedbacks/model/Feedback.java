package com.bookshop.HacmeBooks2.feedbacks.model;

import com.bookshop.HacmeBooks2.products.model.*;

import javax.persistence.*;

@Entity
public class Feedback {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id = 0;
  public String feedback = "";
  // TODO : add user field
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID_FK")
  private Product product = null;

  public Feedback() {
    // For hibernate
  }

  public Feedback(String feedback, Product product) {
    this.feedback = feedback;
    this.product = product;
  }
}
