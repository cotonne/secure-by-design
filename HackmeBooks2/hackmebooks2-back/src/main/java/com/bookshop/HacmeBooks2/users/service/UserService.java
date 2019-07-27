package com.bookshop.HacmeBooks2.users.service;

import com.bookshop.HacmeBooks2.users.model.User;
import com.bookshop.HacmeBooks2.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcUserDetailsManager manager;

    public Optional<Object> signup(User user) {
        try{
            Optional<Object> maybeUser = Optional.of(userRepository.save(user));
            maybeUser.ifPresent(x -> manager.addUserToGroup(user.getUsername(), "USER"));
            return maybeUser;
        }catch (DataIntegrityViolationException e){
            return Optional.empty();
        }
    }
}
