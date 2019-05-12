package com.bookshop.HacmeBooks2.orders.service;

import com.bookshop.HacmeBooks2.orders.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class OrdersService {
  @Autowired
  private OrdersRepository repository;

  public Set<Order> findBy(String principalName) {
    return repository.findByName(principalName);
  }
}
