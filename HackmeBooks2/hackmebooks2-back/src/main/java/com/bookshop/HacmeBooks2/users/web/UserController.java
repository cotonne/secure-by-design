package com.bookshop.HacmeBooks2.users.web;

import com.bookshop.HacmeBooks2.users.model.User;
import com.bookshop.HacmeBooks2.users.service.UserService;
import com.bookshop.HacmeBooks2.users.web.dto.SignupDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user")
  Principal getUser(Principal user) {
    return user;
  }

  @PostMapping("/signup")
  ResponseEntity signup(@RequestBody @Valid SignupDto dto) {
    User user = map(dto);
    return userService.signup(user)
            .map(e -> ResponseEntity.ok().build())
            .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
  }

  private User map(SignupDto dto) {
    User user = new User();
    user.setUsername(dto.username);
    user.setPassword(dto.password);
    user.setFirstName(dto.first_name);
    user.setLastName(dto.last_name);
    user.setEmail(dto.email);
    user.setPhone(dto.phone_number);
    user.setSsn(dto.ssn);
    user.setPasswordHint(dto.password_hint);
    return user;
  }
}
