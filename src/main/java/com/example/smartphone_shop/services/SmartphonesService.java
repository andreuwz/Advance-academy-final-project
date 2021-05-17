package com.example.smartphone_shop.services;

import com.example.smartphone_shop.models.Smartphones;
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
public class SmartphonesService {

    private SmartphonesRepository smartphonesRepository;

    @Autowired
    public SmartphonesService(SmartphonesRepository smartphonesRepository) {
        this.smartphonesRepository=smartphonesRepository;
    }
    //here we write the standard CRUD operations, for the service classes

    public Set<Smartphones> findAll() {
        return smartphonesRepository.findAll()
                .stream()
                .collect(Collectors.toSet());
        // or return new HashSet<>(smartphonesRepository.findAll());
    }

    public void save(@NonNull Smartphones smartphone) {
        smartphonesRepository.save(smartphone);
    }

    public Smartphones findById(@NonNull Long id) {
        return smartphonesRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Smartphones findByName(@NonNull String smartphoneName) {
        return smartphonesRepository.findByName(smartphoneName)
                .orElseThrow(IllegalArgumentException::new); // this comes from <Optional> in the repository
    }

    public void deleteById(@NonNull Long id) {
        smartphonesRepository.deleteById(id);
    }

    public void deleteByName(@NonNull String smartphoneName) {
        smartphonesRepository.deleteByName(smartphoneName);
    }
}
