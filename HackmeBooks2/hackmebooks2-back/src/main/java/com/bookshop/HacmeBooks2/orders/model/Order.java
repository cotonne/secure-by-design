package com.bookshop.HacmeBooks2.orders.model;

import javax.persistence.*;
import java.math.*;

@Entity
public class Order {
  @Id
  private int id;
  private BigInteger orderNumber;
  private float salesTax;
  private String creditCard;
  private char shipped;
  private String total;
  private String bankAccount;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public BigInteger getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(BigInteger orderNumber) {
    this.orderNumber = orderNumber;
  }

  public float getSalesTax() {
    return salesTax;
  }

  public void setSalesTax(float salesTax) {
    this.salesTax = salesTax;
  }

  public String getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(String creditCard) {
    this.creditCard = creditCard;
  }

  public char getShipped() {
    return shipped;
  }

  public void setShipped(char shipped) {
    this.shipped = shipped;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }
}
