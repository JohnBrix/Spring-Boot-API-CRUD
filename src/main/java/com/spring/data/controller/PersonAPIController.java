package com.spring.data.controller;

import com.spring.data.domain.MessageBody;
import com.spring.data.domain.Person;
import com.spring.data.exception.MeetingDoesNotExistException;
import com.spring.data.exception.Message;
import com.spring.data.exception.ResourceNotFoundException;
import com.spring.data.service.PersonService;
import com.spring.data.util.UriUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//whole example http://localhost:6969/api/persons/1
@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins= { "http://localhost:6969", }, maxAge=3000) //host
public class PersonAPIController {
    private final PersonService personService;

    public PersonAPIController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}" )
    public ResponseEntity<Person> findById(@PathVariable Integer id){
        return personService.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> {
                    List<Message> messages = new ArrayList<>();
                    messages.add(new Message("Person with ID " + id + " was not found."));
                    return new ResourceNotFoundException(messages, UriUtil.path(id));
                });    }

    @GetMapping()
    public List<Person> findAll() {
        return this.personService.findAll();
    }

    @PostMapping()
    public ResponseEntity <Person> createPerson(@RequestBody Person personCreate){

        return new ResponseEntity(personService.createPerson(personCreate), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody @Valid Person person) {
        return this.personService.findById(id)
                .map(existingPerson -> ResponseEntity.ok(this.personService.updatePerson(person)
                )).orElseThrow(() -> new MeetingDoesNotExistException(id));
    }


    @DeleteMapping("/{id}") //{id} sa URi SYA NAG uupdate example http://localhost:6969/api/persons/23
    public ResponseEntity<MessageBody> delete(@PathVariable Long id){
    MessageBody messageBody = new MessageBody();
        return this.personService.findById(id) //method of findid in mysql
                .map(Person -> {
                    this.personService.deleteById(id); //method delete

                    return ResponseEntity.ok(messageBody); //once success
                }).orElseThrow(new MeetingDoesNotExistException(id)); //once failed


    }


}
