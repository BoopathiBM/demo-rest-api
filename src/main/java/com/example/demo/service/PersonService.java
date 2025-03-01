package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
@Transactional 
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPeople() {

        return personRepository.findAll();

    }

    public Person getPerson(long id) {
        Optional<Person> newPerson = personRepository.findById(id);
        if (newPerson.isEmpty()) {
            throw new RuntimeException("Person not found");
        }
        return newPerson.get();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(long id, Person updatePerson) {

        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            var dpPerson = optionalPerson.get();
            dpPerson.setName(updatePerson.getName());
            dpPerson.setEmail(updatePerson.getEmail());

            return personRepository.save(dpPerson);
        }
        throw new RuntimeException("Person not found");
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
        
        //throw new UnsupportedOperationException("Unimplemented method 'deletePerson'");
    }

    
}
