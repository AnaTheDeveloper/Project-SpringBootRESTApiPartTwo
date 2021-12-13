package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class ShowAllResultsPage {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping(path = "/showAllResultsOfPerson")
    public String returnShowAllResultsHtmlPage(Model model){


        //collect all info in database

        String url = "http://localhost:8081/api/v1/person/all";

        ReturnMessage response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ReturnMessage.class)
                .block();


        // show everything in the database to page
        System.out.println(response.getReturnMessage());

        model.addAttribute("allResults", response.getReturnMessage());

        System.out.println("Show All Results page hit");
        return "ShowAllResultsPage";

    }
}
