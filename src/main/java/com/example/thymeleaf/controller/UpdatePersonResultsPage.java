package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Person;
import com.example.thymeleaf.model.UpdatePerson;
import com.example.thymeleaf.model.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller
public class UpdatePersonResultsPage {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping(path = "/updateResult")
    public String returnUpdateResultsPage(@ModelAttribute(value = "personToUpdate") UpdatePerson idToUpdateWith, Model model){

        String idToUpdate = idToUpdateWith.getIdToUpdateWith();
        String nameToUpdate = idToUpdateWith.getNameToUpdate();

        Person person = new Person();
        person.setId(idToUpdate);
        person.setName(nameToUpdate);



        String json = "{\"id\":\" " + idToUpdateWith.getIdToUpdateWith() + "\",\"name\":\"No Longer Admin\"}";

        String url = "http://localhost:8081/api/v1/person/update";


        ReturnMessage response = webClientBuilder.build()
                .patch()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(person),Person.class)
                .retrieve()
                .bodyToMono(ReturnMessage.class)
                .block();

        System.out.println(response.toString());

        model.addAttribute("resultOfUpdate", response.toString());

        System.out.println("Person updated was hit");

        return "UpdateResultsPage";


    }




}
