package com.spring.data.service;

import com.spring.data.domain.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person getPersonById(Integer id);

    Person savePerson(Person person);
}
