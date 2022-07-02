package com.enesseven.repository;

import com.enesseven.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);

    Person findByName(String name);

    List<Person> findByNameContainingIgnoreCase(String username);


}

