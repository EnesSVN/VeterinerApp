package com.enesseven.services;

import com.enesseven.model.Animal;
import com.enesseven.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    public List<Animal> listAnimal() {
        return animalRepository.findAll();
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).get();
    }




}
