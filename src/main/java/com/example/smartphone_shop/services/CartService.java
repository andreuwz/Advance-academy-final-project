package com.example.smartphone_shop.services;

import com.example.smartphone_shop.models.Cart;
import com.example.smartphone_shop.repository.CartRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private CartRepository cartRepository;
    private SmartphonesService smartphonesService;

    @Autowired
    public CartService(CartRepository cartRepository, SmartphonesService smartphonesService){
        this.cartRepository = cartRepository;
        this.smartphonesService = smartphonesService;

    }

    public void save(@NonNull Cart cart) {

    }

}
