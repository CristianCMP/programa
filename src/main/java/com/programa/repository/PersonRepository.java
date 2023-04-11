package com.programa.repository;

import com.programa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person,Integer> {
}
