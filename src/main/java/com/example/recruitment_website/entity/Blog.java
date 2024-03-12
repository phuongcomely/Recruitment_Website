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
@Table(name = "blogs")
public class Blog {
//    BlogID int [primary key]
//    Title varchar(255)
//    Poster varchar(255)
//    Author varchar(255)
//    PublicDate date
//    Content varchar(255)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String poster;
    String author;
    Date publicDate;
    @Column(columnDefinition = "TEXT")
    String content;
}
