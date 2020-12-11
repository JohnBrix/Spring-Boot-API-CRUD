package com.spring.data.service;

import com.spring.data.domain.Person;
import com.spring.data.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;


    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll(){
    return this.personRepository.findAll();
    }
    @Override
    public Person getPersonById(Integer id) {

        return this.personRepository.findById(id).get();
    }
    @Override
    public Person savePerson(Person person){

        return this.personRepository.save(person);
    }


}
