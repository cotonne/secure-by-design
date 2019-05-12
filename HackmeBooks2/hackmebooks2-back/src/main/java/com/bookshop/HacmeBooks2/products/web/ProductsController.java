package com.bookshop.HacmeBooks2.products.web;

import com.bookshop.HacmeBooks2.products.model.*;
import com.bookshop.HacmeBooks2.products.repository.*;
import com.bookshop.HacmeBooks2.products.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductsController {

  @Autowired
  private ProductRepository repository;

  @Autowired
  private SearchService searchService;

  @GetMapping("/products")
  public Page<Product> list(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @GetMapping("/products/{id}")
  public Optional<Product> findBy(@PathVariable("id") Integer id) {
    return repository.findById(id);
  }

  @GetMapping("/products/_search")
  public List<Product> search(@RequestParam("q") String query) {
    return searchService.search(query);
  }
}
