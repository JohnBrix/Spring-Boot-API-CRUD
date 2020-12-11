package com.spring.data.service;

import com.spring.data.domain.Person;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Service
public interface PersonService {

    List<Person> findAll();

     Person createPerson(Person personCreate);


    void deleteById(Long person);

    Optional<Person> findById(Long person);

    Optional<Person> getPersonById(Integer id);

    Person updatePerson(@Valid Person person);

    Person savePerson(Person person);

    void deletePerson(Person id);
}
