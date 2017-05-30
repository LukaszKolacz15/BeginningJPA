package com.akademiakodu.BeginningJPA.controllers;

import com.akademiakodu.BeginningJPA.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Lukasz Kolacz on 30.05.2017.
 */

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepository;


}
