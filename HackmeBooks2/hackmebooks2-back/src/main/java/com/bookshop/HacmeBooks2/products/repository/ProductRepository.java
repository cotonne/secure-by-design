package com.bookshop.HacmeBooks2.products.repository;

import com.bookshop.HacmeBooks2.products.model.*;
import org.springframework.data.jpa.repository.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
