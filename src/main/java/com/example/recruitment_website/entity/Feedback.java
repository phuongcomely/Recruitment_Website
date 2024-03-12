package com.example.recruitment_website.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "feedbacks")
public class Feedback {
//    FeedbackID int [primary key]
//    FullName varchar(255)
//    email varchar(255)
//    Phone int
//    Title varchar(255)
//    Content varchar(255)
//    Date date
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String fullName;
    String email;
    Integer phone;
    String title;
    @Column(columnDefinition = "TEXT")
    String content;
    Date date;

}
