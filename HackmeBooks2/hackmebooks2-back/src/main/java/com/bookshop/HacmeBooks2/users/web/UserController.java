package com.bookshop.HacmeBooks2.users.web;

import org.springframework.web.bind.annotation.*;

import java.security.*;

@RestController
public class UserController {

  @GetMapping("/user")
  Principal getUser(Principal user) {
    return user;
  }
}
