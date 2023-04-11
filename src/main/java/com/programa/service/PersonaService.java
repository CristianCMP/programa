package com.programa.service;

import com.programa.model.Person;
import com.programa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    private PersonRepository repository;

    @Autowired

    public PersonaService(PersonRepository repository) {
        this.repository = repository;
    }

    public void save(Person person){
        this.repository.save(person);
    }
}
