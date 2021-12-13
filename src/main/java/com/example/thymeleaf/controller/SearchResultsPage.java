package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.IdToSearchWith;
import com.example.thymeleaf.model.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.reactive.function.client.WebClient;


@Controller
public class SearchResultsPage {


    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping(path = "/searchResult")
    public String returnHomePage(@ModelAttribute(value = "personToFind")IdToSearchWith idToSearchWith, Model model) {

        String userInput = idToSearchWith.getIdToSearchWith();

        String url = "http://localhost:8081/api/v1/person/id?idToSearchWith="+userInput;

        ReturnMessage response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ReturnMessage.class)
                .block();

        System.out.println(response.toString());

        model.addAttribute("resultOfSearch", response.toString());
        return "SearchByIdResults";
    }
}
