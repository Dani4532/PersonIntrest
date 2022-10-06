package com.example.personintrest.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @PastOrPresent
    private LocalDate dateOfBirth;

    @ManyToMany
    @Max(3)
    private Set<Interest> interests = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Sex sex;
}
