package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.IdToDeleteWith;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeletePersonPage {

    @GetMapping(path = "/deletePerson")
    public String returnMsgThatDeletedPersonIsGoneAndWhoWasDeletedPersonHtmlPage(Model model){

        IdToDeleteWith idToDeleteWith = new IdToDeleteWith();

        model.addAttribute("personToDelete", idToDeleteWith);

        System.out.println("Delete page hit");
        return "DeletePage";

    }
}
