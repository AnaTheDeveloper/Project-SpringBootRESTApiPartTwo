package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.AddPersonModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddPersonPage {

    @GetMapping(path = "/addPerson")
    public String returnAddPersonHtmlPage(Model model){

        AddPersonModel addPersonModel = new AddPersonModel();
        model.addAttribute("personToAdd", addPersonModel);

        System.out.println("Add page hit");
        return "AddPerson";

    }

}
