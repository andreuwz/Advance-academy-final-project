package com.example.smartphone_shop.controller;

import com.example.smartphone_shop.model.Smartphone;
import com.example.smartphone_shop.repository.SmartphoneRepository;
import com.example.smartphone_shop.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartphoneController {

    private SmartphoneService smartphoneService;

    @Autowired
    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }


}


