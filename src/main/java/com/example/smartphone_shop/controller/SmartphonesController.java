package com.example.smartphone_shop.controller;

import com.example.smartphone_shop.models.Smartphones;
import com.example.smartphone_shop.repository.SmartphonesRepository;
import com.example.smartphone_shop.services.SmartphonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class SmartphonesController {

    private SmartphonesRepository smartphonesRepository;
    private SmartphonesService smartphonesService;

    @Autowired
    public SmartphonesController(SmartphonesRepository smartphonesRepository) {
        this.smartphonesRepository = smartphonesRepository;
    }

//    @GetMapping
//    public Set<Smartphones> findAll() {
//        return smartphonesService.findAll();
//    }
}


