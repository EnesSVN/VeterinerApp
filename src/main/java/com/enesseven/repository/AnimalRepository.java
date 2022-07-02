package com.enesseven.repository;

import com.enesseven.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {


    List<Animal> findByNameContainingIgnoreCase(String username);

}
