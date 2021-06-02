package com.example.smartphone_shop.controller;


import com.example.smartphone_shop.model.Cart;
import com.example.smartphone_shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Set;

@RestController
@Transactional
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(value = "/allcarts")
    public ResponseEntity<Set<Cart>> returnAllCarts() {
        return ResponseEntity.ok(cartService.returnAllCarts());
    }

    @PostMapping(value = "/savecart")
    public ResponseEntity<HttpStatus> addCart(@RequestBody Cart cart) {
        cartService.saveCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/cartname/{cartname}")
    public ResponseEntity<Cart> findCartByName(@PathVariable String cartname) {
        return ResponseEntity.ok(cartService.findCartByName(cartname));
    }

    @GetMapping(value = "/cartid/{id}")
    public ResponseEntity<Cart> findCartById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(cartService.findCartById(id));
    }

    @DeleteMapping(value = "/cartdelete/{cartname}")
    public ResponseEntity<HttpStatus> deleteByCartName(@PathVariable String cartname) {
        cartService.deleteCart(cartname);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/allcartdelete/deleteall")
    public ResponseEntity<HttpStatus> deleteAllCarts() {
        cartService.deleteAllCarts();
        return ResponseEntity.ok().build();
    }

}
