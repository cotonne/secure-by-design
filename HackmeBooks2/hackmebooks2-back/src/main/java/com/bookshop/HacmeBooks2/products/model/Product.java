package com.bookshop.HacmeBooks2.products.model;

import com.bookshop.HacmeBooks2.feedbacks.model.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = "PRODUCTS")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id = 0;
  private String title;
  private String description;
  private int popularity;
  private double price = 0;
  private String vendor;
  private String category;
  private String publisher;
  private String isbn;
  private String author;
  private int quantity = 0;
  private transient long uid = System.currentTimeMillis();
  private transient String keyWords;
  private String imgurl = null;
  @OneToMany()
  @JoinTable(
          name = "FEEDBACK",
          joinColumns = {
                  @JoinColumn(name = "PRODUCT_ID_FK")
          },
          inverseJoinColumns = {
                  @JoinColumn(name = "ID")
          })
  private List<Feedback> feedbacks = new ArrayList<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }

  public String getKeyWords() {
    return keyWords;
  }

  public void setKeyWords(String keyWords) {
    this.keyWords = keyWords;
  }

  public String getImgurl() {
    return imgurl;
  }

  public void setImgurl(String imgurl) {
    this.imgurl = imgurl;
  }

  public List<Feedback> getFeedbacks() {
    return feedbacks;
  }

  public void setFeedbacks(List<Feedback> feedbacks) {
    this.feedbacks = feedbacks;
  }
}
