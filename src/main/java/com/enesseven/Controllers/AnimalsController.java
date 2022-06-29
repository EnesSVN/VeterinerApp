package com.enesseven.Controllers;

import com.enesseven.model.Animal;
import com.enesseven.model.Person;
import com.enesseven.services.AnimalService;
import com.enesseven.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AnimalsController {

    private AnimalService animalService;
    private PersonService personService;

    public AnimalsController(AnimalService animalService, PersonService personService) {
        this.animalService = animalService;
        this.personService = personService;
    }
    @GetMapping("/animals")
    public String getAnimals(Model model) {
        model.addAttribute("animals", animalService.listAnimal());
        return "animals";
    }

    //http://localhost:8081/animal/create
    @GetMapping("/animal/create")
    public String getAnimalCreate(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        model.addAttribute("person", personService.listPerson());
        return "animal_create";
    }

    @PostMapping("/animals")
    public String postAnimalCreate(@RequestParam Long person_id, @ModelAttribute("animal") Animal animal) {
        Person person = personService.getPersonById(person_id);
        animal.setPerson(person);
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

}
