package com.example.smartphone_shop.repository;

import com.example.smartphone_shop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByCartName(String cartName);

    void deleteByCartName (String cartName);

}
