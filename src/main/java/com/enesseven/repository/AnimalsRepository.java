package com.enesseven.repository;

import com.enesseven.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalsRepository extends JpaRepository<Animal, Long> {


}
