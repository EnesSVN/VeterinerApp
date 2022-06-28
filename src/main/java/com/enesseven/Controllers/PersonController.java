package com.enesseven.Controllers;


import com.enesseven.model.Person;
import com.enesseven.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    //http://localhost:8081/persons
    @GetMapping("/persons")
    public String getPerson(Model model) {
        Person person = new Person();
        model.addAttribute("persons",personService.listPerson());
        return "persons";
    }

    //http://localhost:8081/person/create
    @GetMapping("/person/create")
    public String getPersonCreate(Model model) {
        Person person = new Person();
        model.addAttribute("person",person);
        return "person_create";
    }


    @PostMapping("/persons")
    public String postPersonCreate(@ModelAttribute("person") Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }
    ///////////////////////////

    @GetMapping("/person/update/{id}")
    public String getPersonUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("person",personService.getPersonById(id));
        return "person_update";
    }

    //http://localhost:8081/person/update/1
    @PostMapping("/person/{id}")
    public String postPersonUpdate(@PathVariable Long id, @ModelAttribute("person") Person person){

        Person existingPerson = personService.getPersonById(id);
        existingPerson.setId(id);
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setPhone(person.getPhone());
        existingPerson.setEmail(person.getEmail());

        personService.updatePerson(existingPerson);
        return "redirect:/persons";
    }





    @GetMapping("/person/delete/{id}")
    public String personelDelete(@PathVariable Long id){
        personService.deletePerson(id);
        return "redirect:/persons";
    }

}
