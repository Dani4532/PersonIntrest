package com.example.personintrest.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
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

    @NotEmpty
    @Pattern(regexp = "^[A-Z][a-z]{3,28}$")
    private String firstName;

    @NotEmpty
    @Pattern(regexp = "^[A-Z][a-z]{3,28}$")
    private String lastName;

    @PastOrPresent
    private LocalDate dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL)
    @Size(max = 3)
    private Set<Interest> interests = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return id != null && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Person(Integer id, String firstName, String lastName, LocalDate dateOfBirth, Sex sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }
}
