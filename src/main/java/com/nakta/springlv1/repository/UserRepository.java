package com.nakta.springlv1.repository;

import com.nakta.springlv1.entity.Board;
import com.nakta.springlv1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
