package com.bookshop.HacmeBooks2.products.web;

import com.bookshop.HacmeBooks2.products.model.Product;
import com.bookshop.HacmeBooks2.products.repository.ProductRepository;
import com.bookshop.HacmeBooks2.products.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

  private final ProductRepository repository;

  private final SearchService searchService;

  public ProductsController(ProductRepository repository, SearchService searchService) {
    this.repository = repository;
    this.searchService = searchService;
  }

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
