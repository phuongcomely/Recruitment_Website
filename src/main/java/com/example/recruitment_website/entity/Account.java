package com.example.recruitment_website.entity;

import com.example.recruitment_website.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
    Integer id;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    @Enumerated(EnumType.STRING)
    Role role;

//    @ManyToOne
//    @JoinColumn(name = "candidate_id")
//    private Candidate candidate;
//    @ManyToOne
//    @JoinColumn(name = "employer_id")
//    private Employer employer;
//    @ManyToOne
//    @JoinColumn(name = "admin_id")
//    private Admin admin;

}
