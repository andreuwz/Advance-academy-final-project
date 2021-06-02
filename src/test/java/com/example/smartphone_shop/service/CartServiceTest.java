package com.example.smartphone_shop.service;

import com.example.smartphone_shop.repository.CartRepository;
import com.example.smartphone_shop.services.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CartServiceTest {

    private CartService cartService;
    @Mock
    private CartRepository cartRepository;

    @BeforeEach
    public void init() {
        cartService = new CartService(cartRepository);
    }

    @Test
    public void testOneExpectNullPointerException() {
        cartService.findCartById(null);
        Assertions.assertThrows(NullPointerException.class, () -> {cartService.findCartById(null);});
    }

    @Test
    public void  testTwoExpectNullPointerException() {
        cartService.findCartByName(null);
        Assertions.assertThrows(NullPointerException.class, ()-> {cartService.findCartByName(null);});
    }

}
