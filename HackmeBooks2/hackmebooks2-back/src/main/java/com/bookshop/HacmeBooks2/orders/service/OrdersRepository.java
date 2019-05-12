package com.bookshop.HacmeBooks2.orders.service;

import com.bookshop.HacmeBooks2.orders.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer> {
  @Query(value = "SELECT * FROM ORDERS O JOIN USERS U ON U.ID=O.USERS_ID_FK WHERE U.USERNAME = ?1", nativeQuery = true)
  Set<Order> findByName(String principalName);
}
