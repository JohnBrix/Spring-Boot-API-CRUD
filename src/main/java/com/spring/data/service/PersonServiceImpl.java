package com.spring.data.service;

import com.spring.data.domain.Person;
import com.spring.data.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public Person createPerson(Person personCreate) {
            Person newPerson = new Person();


            newPerson.setFirstName(personCreate.getFirstName());
            newPerson.setLastName(personCreate.getLastName());
            newPerson.setAge(personCreate.getAge());
        //dapat person ang return mo para sa postman mga model ilalabas
            return personRepository.save(newPerson);
    }
    @Override
    public void deleteById(Long person){

       personRepository.deleteById(Math.toIntExact(person));
    }
    @Override
    public Optional<Person> findById(Long person) {
        return this.personRepository.findById(Math.toIntExact(person));
    }

    @Override
    public Optional<Person> getPersonById(Integer id) {

        return this.personRepository.findById(id);
    }

    @Override
    public Person updatePerson(@Valid Person person){

        return this.personRepository.save(person);
    }

    @Override
    public Person savePerson(Person person){

        return this.personRepository.save(person);
    }
    @Override
    public void deletePerson(Person id){

        this.personRepository.deleteById(id.getId());
    }
//    @Override
//    public Person updatePerson(Person person){
//
//        return this.personRepository
//    }

}
