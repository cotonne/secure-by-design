package com.bookshop.HacmeBooks2.orders.web;

import com.bookshop.HacmeBooks2.orders.model.*;
import com.bookshop.HacmeBooks2.orders.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.security.*;
import java.util.*;

@RestController
public class OrdersController {

  @Autowired
  public OrdersService service;

  @GetMapping("/orders")
  public Set<Order> getOrders(Principal principal){
    return service.findBy(principal.getName());
  }
}
