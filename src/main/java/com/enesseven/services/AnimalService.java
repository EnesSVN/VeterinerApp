package com.enesseven.services;

import com.enesseven.model.Animal;
import com.enesseven.repository.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalsRepository animalsRepository;


    public List<Animal> listAnimal() {
        return animalsRepository.findAll();
    }

    public Animal saveAnimal(Animal animal) {
        return animalsRepository.save(animal);
    }

    public Animal updateAnimal(Animal animal) {
        return animalsRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalsRepository.deleteById(id);
    }

    public Animal getAnimalById(Long id) {
        return animalsRepository.findById(id).get();
    }




}
