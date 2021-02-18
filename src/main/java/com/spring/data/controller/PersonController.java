package com.spring.data.controller;

import com.spring.data.domain.Person;
import com.spring.data.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }



    @RequestMapping(value = {"/","/view"})
    public String getIndex(@ModelAttribute(name="person") Person person,Model model){
      List<Person> persons = personService.findAll();
      model.addAttribute("persons",persons); // to connecting html to java value in sql
        return "index";
    }
    //modal
    //si POST naka hide data
    //si GET nakikita sa URL data
//    postmapping mas maganda specific
   /* @PostMapping("/")
    public String saveModal(@Valid Person person, BindingResult bindingResult, Model model){

        System.out.println("/normal");

        this.personService.savePerson(person);
        return "redirect:/view";
    }
    @PostMapping("/update{id}")
    public String updatePerson(Person person) {
        System.out.println("my id: "+person.getId());
        this.personService.savePerson(person);
        return "redirect:/view";
    }
    @PostMapping("/delete{id}")
    public String deletePerson(Person person){


        this.personService.deletePerson(person);
        return "redirect:/view";
    }*/

    
}
