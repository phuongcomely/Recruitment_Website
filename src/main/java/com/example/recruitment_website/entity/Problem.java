package com.example.recruitment_website.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "problems")
public class Problem {
//    ProblemID int [primary key]
//    EmployerID int
//    Title varchar(255)
//    Content varchar(255)
//    Picture varchar(255)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    @Column(columnDefinition = "TEXT")
    String content;
    String picture;

    @ManyToMany
    @JoinTable(
            name = "problem_employer",
            joinColumns = @JoinColumn(name = "problem_id"),
            inverseJoinColumns = @JoinColumn(name = "employer_id")
    )
    private List<Employer>  employers;


}
