package com.bookshop.HacmeBooks2.orders.web;

import com.bookshop.HacmeBooks2.orders.model.Order;
import com.bookshop.HacmeBooks2.orders.service.OrdersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Set;

@RestController
public class OrdersController {

  public final OrdersService service;

  public OrdersController(OrdersService service) {
    this.service = service;
  }

  @GetMapping("/orders")
  public Set<Order> getOrders(Principal principal){
    return service.findBy(principal.getName());
  }
}
