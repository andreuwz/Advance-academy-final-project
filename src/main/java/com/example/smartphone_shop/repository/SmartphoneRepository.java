package com.example.smartphone_shop.repository;

import com.example.smartphone_shop.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    Optional<Smartphone> findBySmartphoneName(String smartphoneName);

    Optional<Smartphone> findBySmartphonePrice(String smartphonePrice);

    void deleteBySmartphoneName(String smartphoneName);
}
