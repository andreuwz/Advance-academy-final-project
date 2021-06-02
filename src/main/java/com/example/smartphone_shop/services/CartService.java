package com.example.smartphone_shop.services;

import com.example.smartphone_shop.exception.RecordNotFoundException;
import com.example.smartphone_shop.model.Cart;
import com.example.smartphone_shop.repository.CartRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public void saveCart(@NonNull Cart cart) {
        cartRepository.save(cart);
        cart.setCartCreationDate(LocalDateTime.now());
        System.out.println("Cart saved successfully!");
    }

    public void deleteCart(@NonNull String cartname) {
        cartRepository.deleteByCartName(cartname);
        System.out.println("Cart deleted successfully");
    }

    public Cart findCartById(@NonNull Long id) {
        Cart foundCartI = cartRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Cart with id %s not found", id)));
        return foundCartI;
    }

    public Cart findCartByName(@NonNull String cartName) {
        Cart foundCartN = cartRepository.findByCartName(cartName)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Cart with name %s not found", cartName)));
        return foundCartN;
    }

    public Set<Cart> returnAllCarts() {
        return new HashSet<>(cartRepository.findAll());

    }
    public void deleteAllCarts() {
        cartRepository.deleteAll();
        System.out.println("All carts deleted successfully!");
    }

}
