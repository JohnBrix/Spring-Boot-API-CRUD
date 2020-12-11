package com.spring.data.controller;

import com.spring.data.domain.Person;
import com.spring.data.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/", method =RequestMethod.POST)
    public String saveModal(@Valid Person person, BindingResult bindingResult, Model model){
        
        System.out.println("/normal");

        this.personService.savePerson(person);
        return "redirect:/view";
    }

    //pag walang model attribute di mo maggwa makuha yung setter and getter nito.
    @RequestMapping(value = "/add")
    public String getAdd(@ModelAttribute(name="person") Person person, Model model){

        return "add";
    }
    @RequestMapping(value = "/add", method =RequestMethod.POST)
    public String save(@Valid Person person, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            System.out.println("true has errors");

            return "add"; //para mapalabas laman ng validation
        }

        this.personService.savePerson(person);
        return "redirect:/view";
    }
    
}
