package com.example.smartphone_shop.repository;

import com.example.smartphone_shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFirstname(String firstname);

    Optional<User> findByLastname(String lastname);

    Optional<User> findByEmailAddress(String emailAddress);

    void deleteByFirstname(String firstname);

}
