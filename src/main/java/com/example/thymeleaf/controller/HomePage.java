package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping(path = "/homePage")
    public String HomePage(){




        return "HomePage";
    }
    //Show all results
    //SearchById
    //Add Person
    //Update Person
    //Delete Person


}
