package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.IdToSearchWith;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchPage {


    @GetMapping(path = "/searchById")
    public String returnSearchByIdHtmlPage(Model model) {

        IdToSearchWith idToSearchWith = new IdToSearchWith();

        model.addAttribute("personToFind", idToSearchWith);
        return "SearchById";
    }
}
