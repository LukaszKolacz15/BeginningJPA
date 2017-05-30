package com.akademiakodu.BeginningJPA.controllers;

import com.akademiakodu.BeginningJPA.PersonRepository;
import com.akademiakodu.BeginningJPA.models.Person;
import com.akademiakodu.BeginningJPA.models.forms.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Lukasz Kolacz on 30.05.2017.
 */

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/newform", method = RequestMethod.GET)
    public String newform(Model model){
        model.addAttribute("personObject", new PersonForm());
        return "form";
    }

    @RequestMapping(value = "/newform", method = RequestMethod.POST)
    public String newformPost(@ModelAttribute("personObject")@Valid PersonForm personForm, BindingResult result){
        if(result.hasErrors()){
            return "form";
        }
        Person personObject = new Person(personForm);
        personRepository.save(personObject);
        return "result";
    }
}
