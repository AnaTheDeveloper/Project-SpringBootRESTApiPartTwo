package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.IdToDeleteWith;
import com.example.thymeleaf.model.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class DeleteResultsPage {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping(path = "/deleteResult")
    public String returnDeleteResultsPage(@ModelAttribute(value = "personToDelete")IdToDeleteWith idToDeleteWith, Model model){

        String userInput = idToDeleteWith.getIdToDeleteWith();

        String url = "http://localhost:8081/api/v1/person/delete?idToDeleteWith=" + userInput;

        ReturnMessage response = webClientBuilder.build()
                .delete()
                .uri(url)
                .retrieve()
                .bodyToMono(ReturnMessage.class)
                .block();

        System.out.println(response.toString());

        model.addAttribute("resultOfDelete", response.toString());

        System.out.println("Person Deleted point was hit");
        return "DeletePageResults";
    }





}
