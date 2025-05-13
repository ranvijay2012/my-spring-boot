package com.spring.boot.repository;

import com.spring.boot.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
