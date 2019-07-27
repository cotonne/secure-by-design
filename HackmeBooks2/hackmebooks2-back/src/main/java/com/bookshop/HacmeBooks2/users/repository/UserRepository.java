package com.bookshop.HacmeBooks2.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookshop.HacmeBooks2.users.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String john);
}
