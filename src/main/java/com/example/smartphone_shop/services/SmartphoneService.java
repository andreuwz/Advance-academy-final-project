package com.example.smartphone_shop.services;

import com.example.smartphone_shop.exception.SmartphoneNotFoundException;
import com.example.smartphone_shop.model.Smartphone;
import com.example.smartphone_shop.repository.SmartphoneRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SmartphoneService {

    private SmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    public List<Smartphone> findAllSmartphones() {
        return smartphoneRepository.findAll();
    }

    public void saveSmartphone(@NonNull Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
        System.out.println("Smartphone saved successfully!");
    }

    public void deleteSmartphoneByName(@NonNull String smartphonename) {
        smartphoneRepository.deleteBySmartphoneName(smartphonename);
        System.out.println("Smartphone deleted successfully!");
    }

    public Smartphone findByName(@NonNull String smartphoneName) {
        Smartphone foundSmartphoneN = smartphoneRepository.findBySmartphoneName(smartphoneName)
                .orElseThrow(() -> new SmartphoneNotFoundException(String.format("Smartphone with name %s not found",
                        smartphoneName)));
        return foundSmartphoneN;
    }

    public Smartphone findByPrice(@NonNull String smartphonePrice) {
        Smartphone foundSmarphoneP = smartphoneRepository.findBySmartphonePrice(smartphonePrice)
                .orElseThrow(() -> new SmartphoneNotFoundException(String.format("Smartphone with price %s not found",
                        smartphonePrice)));
        return foundSmarphoneP;
    }

    public void deleteAllSmartphones(){
        smartphoneRepository.deleteAll();
        System.out.println("All smartphones deleted successfully!");
    }

}
