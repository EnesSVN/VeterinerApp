package com.enesseven.services;

import com.enesseven.model.Person;
import com.enesseven.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    public PersonRepository personRepository;

    public Person savePerson (Person person){

        return personRepository.save(person);
    }

    public List<Person> listPerson (){

        return personRepository.findAll();
    }

    public Person updatePerson (Person person){

        return personRepository.save(person);
    }

    public void deletePerson (Long id){
        personRepository.deleteById(id);
    }

    public Person getPersonByName (String name){

        return personRepository.findByName(name);
    }
    public Person getPersonById (Long id){

        return personRepository.findById(id).get();
    }
}
