package com.enesseven.Controllers;

import com.enesseven.model.Animal;
import com.enesseven.model.Person;
import com.enesseven.services.AnimalService;
import com.enesseven.services.PersonService;
import org.hibernate.query.QueryParameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    private PersonService personService;
    private AnimalService animalService;

    public SearchController(PersonService personService, AnimalService animalService) {
        this.personService = personService;
        this.animalService = animalService;
    }

    @GetMapping("/")
    public String getSearch(Model model, @RequestParam("search") String search) {
        System.out.println(search);
        List<Person> persons = personService.searchPerson(search);
        List<Animal> animals = animalService.searchAnimal(search);

        List searchResult = new ArrayList<>();
        searchResult.addAll(persons);
        searchResult.addAll(animals);

        System.out.println(searchResult.toString());
        model.addAttribute("searchResults", searchResult);
        return "index";
    }
}
