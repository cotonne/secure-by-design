package com.bookshop.HacmeBooks2.orders.service;

import com.bookshop.HacmeBooks2.orders.model.Order;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrdersService {
  private final OrdersRepository repository;

  public OrdersService(OrdersRepository repository) {
    this.repository = repository;
  }

  public Set<Order> findBy(String principalName) {
    return repository.findByName(principalName);
  }
}
