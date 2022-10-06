package com.example.personintrest.controller;

import com.example.personintrest.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public record PersonController(PersonRepository personRepository) {

    @GetMapping("/persons")
    public String getAllPersons(Model model){
        model.addAttribute("personList", personRepository.findAll());
        return "persons";
    }

    @GetMapping("/new")
    public String addNewPerson(Model model){
        model.addAttribute("today", LocalDate.now());
        return "addPage";
    }
}
