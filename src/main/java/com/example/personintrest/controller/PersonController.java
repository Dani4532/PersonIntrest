package com.example.personintrest.controller;

import com.example.personintrest.entity.Interest;
import com.example.personintrest.entity.Person;
import com.example.personintrest.entity.Sex;
import com.example.personintrest.repository.InterestRepository;
import com.example.personintrest.repository.PersonRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "addPage";
    }

    @PostMapping("/post")
    public String saveNewPerson(Model model,
                                @RequestParam(name = "firstName") String firstName,
                                @RequestParam(name = "lastName") String lastName,
                                @RequestParam(name = "dateOfBirth") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                                @RequestParam(name = "sex") String sex,
                                @RequestParam(name = "interest1", required = false) Interest interest1,
                                @RequestParam(name = "interest2", required = false) Interest interest2,
                                @RequestParam(name = "interest3", required = false) Interest interest3,
                                @RequestParam(name = "interest4", required = false) Interest interest4,
                                @RequestParam(name = "interest5", required = false) Interest interest5){

        var newPerson = new Person(null, firstName, lastName, dateOfBirth, Sex.valueOf(sex));
        personRepository.save(newPerson);
        return "redirect:/";
    }
}
