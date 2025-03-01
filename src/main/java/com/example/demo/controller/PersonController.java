package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/people")
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("/people/{id}")
    public Person getPersonDetails(@PathVariable long id) {
        var person = personService.getPerson(id);
        return person;

    }

    @PostMapping("/people")
    public Person createPersons(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @PutMapping("/people/{id}")
    public Person updatePersons(@PathVariable long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable long id){
         personService.deletePerson(id);
    }

}
