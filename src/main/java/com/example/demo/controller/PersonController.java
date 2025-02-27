package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}

