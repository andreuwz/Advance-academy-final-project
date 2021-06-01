package com.example.smartphone_shop.repository;

import com.example.smartphone_shop.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphonesRepository extends JpaRepository<Smartphone, Long> {

}
