package com.example.smartphone_shop.services;

import com.example.smartphone_shop.model.Cart;
import com.example.smartphone_shop.repository.CartRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private CartRepository cartRepository;
    private SmartphoneService smartphoneService;

    @Autowired
    public CartService(CartRepository cartRepository, SmartphoneService smartphoneService){
        this.cartRepository = cartRepository;
        this.smartphoneService = smartphoneService;

    }

    public void save(@NotNull Cart cart) {

    }

}
