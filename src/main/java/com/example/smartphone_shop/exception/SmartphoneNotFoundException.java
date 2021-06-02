package com.example.smartphone_shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SmartphoneNotFoundException extends RuntimeException{

    public SmartphoneNotFoundException(String message) {
        super(message);
    }

}
