package com.example.smartphone_shop.repository;

import com.example.smartphone_shop.models.Smartphones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmartphonesRepository extends JpaRepository<Smartphones, Long> {

    Optional<Smartphones> findByName(String name);
    //the optional class enables using exceptions for when using the method in other classes ! ! !

   void deleteByName(String name);
}
