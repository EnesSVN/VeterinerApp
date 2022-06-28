package com.enesseven.repository;

import com.enesseven.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);

    Person findByName(String name);


}

