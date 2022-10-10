package com.example.personintrest.controller;

import com.example.personintrest.entity.Interest;
import com.example.personintrest.entity.Person;
import com.example.personintrest.entity.Sex;
import com.example.personintrest.repository.InterestRepository;
import com.example.personintrest.repository.PersonRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public record PersonController(PersonRepository personRepository, InterestRepository interestRepository) {


    @GetMapping
    public String getAllPersons(Model model){
        model.addAttribute("personList", personRepository.findAll());
        return "persons";
    }

    @GetMapping("/new")
    public String addNewPerson(Model model){
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("sexes", List.of("MALE","FEMALE", "DIVERSE"));
        model.addAttribute("interests", interestRepository.findAll());
        model.addAttribute("person", new Person());
        return "addPage";
    }

    @PostMapping(value = "/post")
    public String saveNewPerson(Model model, @Valid @ModelAttribute("person") Person newPerson, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return addNewPerson(model);
        }
        personRepository.save(newPerson);

        return "redirect:/";
    }
}
