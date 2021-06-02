package com.example.smartphone_shop.controller;

import com.example.smartphone_shop.model.Smartphone;
import com.example.smartphone_shop.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class SmartphoneController {

    private SmartphoneService smartphoneService;

    @Autowired
    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @GetMapping(value = "/allsmartphones")
    public ResponseEntity<List<Smartphone>> getAllSmartphones() {
        return ResponseEntity.ok(smartphoneService.findAllSmartphones());
    }

    @PostMapping(value = "/savesmartphone")
    public ResponseEntity<HttpStatus> addSmartphone(@RequestBody Smartphone smartphone) {
        smartphoneService.saveSmartphone(smartphone);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/smartphonename/{sname}")
    public ResponseEntity<Smartphone> findBySmartphoneName(@PathVariable String sname) {
        return ResponseEntity.ok(smartphoneService.findByName(sname));
    }

    @GetMapping(value = "/smartphoneprice/{sprice}")
    public ResponseEntity<Smartphone> findBySmartphonePrice(@PathVariable String sprice) {
        return ResponseEntity.ok(smartphoneService.findByPrice(sprice));
    }

    @DeleteMapping(value = "/smartphonedelete/{deletename}")
    public ResponseEntity<HttpStatus> deleteBySmartphoneName(String deletename) {
        smartphoneService.deleteSmartphoneByName(deletename);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/smartphonesdelete/deleteall")
    public ResponseEntity<HttpStatus> deleteAllSmartphones() {
        smartphoneService.deleteAllSmartphones();
        return ResponseEntity.ok().build();
    }

}


