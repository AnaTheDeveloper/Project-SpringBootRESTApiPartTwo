package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.UpdatePerson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpdatePersonPage {

    @GetMapping(path = "/updatePerson")
    public String returnUpdatedPersonHtmlPage(Model model){

        UpdatePerson updatePerson = new UpdatePerson();
        model.addAttribute("personToUpdate", updatePerson);


        System.out.println("Update page hit");
        return "UpdatedPage";

    }
}
