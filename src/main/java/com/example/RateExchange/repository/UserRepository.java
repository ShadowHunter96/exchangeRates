package com.example.RateExchange.repository;

import com.example.RateExchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by User: Vu
 * Date: 28.09.2025
 * Time: 20:57
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    public Optional<User> findByLogin(String login);
    List<User> findByFirstNameIgnoreCase(String firstName);
}

