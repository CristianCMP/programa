package com.programa.controller;

import com.programa.model.Person;
import com.programa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person savePerson(@RequestBody Person person){
        return repository.save(person);
    }

    @GetMapping("/all")
    public List<Person> getPerson (){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Person getAPerson(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Integer id){
        repository
                .findById(id)
                .map(person ->{
                    repository.delete(person);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable Integer id, @RequestBody Person personUpdate){
        repository
                .findById(id)
                .map(person -> {
                    personUpdate.setId(person.getId());
                    return repository.save(personUpdate);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
