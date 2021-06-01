package com.example.smartphone_shop.services;

import com.example.smartphone_shop.model.Smartphone;
import com.example.smartphone_shop.repository.SmartphonesRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional // this creates one physical transaction, so the program has "normal"
//code sequence. For more info check google
public class SmartphoneService {

    private SmartphonesRepository smartphonesRepository;

    @Autowired
    public SmartphoneService(SmartphonesRepository smartphonesRepository) {
        this.smartphonesRepository=smartphonesRepository;
    }
    //here we write the standard CRUD operations, for the service classes

    public Set<Smartphone> findAll() {
        return smartphonesRepository.findAll()
                .stream()
                .collect(Collectors.toSet());
        // or return new HashSet<>(smartphonesRepository.findAll());
    }

    public void save(@NonNull Smartphone smartphone) {
        smartphonesRepository.save(smartphone);
    }

    public Smartphone findById(@NonNull Long id) {
        return smartphonesRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }



    public void deleteById(@NonNull Long id) {
        smartphonesRepository.deleteById(id);
    }


}
