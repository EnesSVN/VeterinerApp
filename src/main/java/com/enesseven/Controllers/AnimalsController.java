package com.enesseven.Controllers;

import com.enesseven.model.Animal;
import com.enesseven.model.Person;
import com.enesseven.services.AnimalService;
import com.enesseven.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AnimalsController {

    private AnimalService animalService;
    private PersonService personService;

    @GetMapping("/animals")
    public String getAnimals(Model model) {
        model.addAttribute("animals", animalService.listAnimal());
        return "animals";
    }

    @GetMapping("/animal/create/{personId}")
    public String getAnimalCreate(@PathVariable Long personId, @ModelAttribute("animal") Animal animal,Model model) {

        Person person = personService.getPersonById(personId);

        Animal creatAnimal = new Animal();
        model.addAttribute("animal", creatAnimal);
        return "animal_create";
    }


}
