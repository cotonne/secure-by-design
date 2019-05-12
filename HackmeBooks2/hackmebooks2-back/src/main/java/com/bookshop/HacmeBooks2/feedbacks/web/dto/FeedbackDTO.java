package com.bookshop.HacmeBooks2.feedbacks.web.dto;

public class FeedbackDTO {
  public String feedback;
  public int productId;

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }
}
