package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.AddPersonModel;
import com.example.thymeleaf.model.Person;
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
public class AddPersonResultsPage {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping(path = "/addResult")
    public String personAddedToDatabase(@ModelAttribute(value = "personToAdd")AddPersonModel addPersonModel, Model model){

        String idToAdd = addPersonModel.getIdToAdd();
        String nameToAdd = addPersonModel.getNameToAdd();

        Person person = new Person();
        person.setId(idToAdd);
        person.setName(nameToAdd);

        String json = "{\"id\":\""+ addPersonModel.getIdToAdd() +"\", \"name\":\""+ addPersonModel.getNameToAdd() +"\"}";


        String url = "http://localhost:8081/api/v1/person/post";

        ReturnMessage response = webClientBuilder.build()
                .post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(person),Person.class)
                .retrieve()
                .bodyToMono(ReturnMessage.class)
                .block();

        System.out.println(response.toString());

        model.addAttribute("resultOfAdd", response.toString());

        System.out.println("Add Person Results Page Hit");
        return "AddPersonResultsPage";
    }
}
